package com.microservices.gamification.service;

import com.microservices.gamification.domain.Badge;
import com.microservices.gamification.domain.BadgeCard;
import com.microservices.gamification.domain.GameStats;
import com.microservices.gamification.domain.ScoreCard;
import com.microservices.gamification.repository.BadgeCardRepository;
import com.microservices.gamification.repository.ScoreCardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 游戏服务impl
 *
 * @author Guy Cui
 */
@Service
@Slf4j
public class GameServiceImpl implements GameService {
    private final ScoreCardRepository scoreCardRepository;
    private final BadgeCardRepository badgeCardRepository;

    GameServiceImpl(ScoreCardRepository scoreCardRepository, BadgeCardRepository badgeCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
        this.badgeCardRepository = badgeCardRepository;
    }

    /**
     * 用户的新尝试
     *
     * @param userId    用户id
     * @param attemptId 尝试id
     * @param correct   正确的
     *
     * @return {@code GameStats}
     */
    @Override
    public GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct) {
        if (correct) {
            ScoreCard scoreCard = new ScoreCard(userId, attemptId);
            scoreCardRepository.save(scoreCard);
            log.info("User with id {} scored {} points for attempt id {}", userId, scoreCard.getScore(), attemptId);
            List<BadgeCard> badgeCards = processForBadges(userId, attemptId);
            return new GameStats(userId, scoreCard.getScore(), badgeCards.stream().map(BadgeCard :: getBadge).collect(Collectors.toList()));
        }
        return null;
    }

    /**
     * 检索用户统计
     *
     * @param userId 用户id
     *
     * @return {@code GameStats}
     */
    @Override
    public GameStats retrieveStatsForUser(final Long userId) {
        int score = scoreCardRepository.getTotalScoreForUser(userId);
        List<BadgeCard> badgeCards = badgeCardRepository.findByUserIdOrderByBadgeTimestampDesc(userId);
        return new GameStats(userId, score, badgeCards.stream().map(BadgeCard :: getBadge).collect(Collectors.toList()));
    }

    /**
     * 过程徽章
     *
     * @param userId    用户id
     * @param attemptId 尝试id
     *
     * @return {@code List<BadgeCard>}
     */
    private List<BadgeCard> processForBadges(final Long userId, final Long attemptId) {
        List<BadgeCard> badgeCards = new ArrayList<>();
        int totalScore = scoreCardRepository.getTotalScoreForUser(userId);
        log.info("New score for user {} is {}", userId, totalScore);

        List<ScoreCard> scoreCardList = scoreCardRepository.findByUserIdOrderByScoreTimestampDesc(userId);
        List<BadgeCard> badgeCardList = badgeCardRepository.findByUserIdOrderByBadgeTimestampDesc(userId);

        // 根据分数获得徽章
        checkAndGiveBadgeBasedOnScore(badgeCardList, Badge.BRONZE_MULTIPLICATOR, totalScore, 100, userId).ifPresent(badgeCards :: add);
        checkAndGiveBadgeBasedOnScore(badgeCardList, Badge.SILVER_MULTIPLICATOR, totalScore, 500, userId).ifPresent(badgeCards :: add);
        checkAndGiveBadgeBasedOnScore(badgeCardList, Badge.GOLD_MULTIPLICATOR, totalScore, 999, userId).ifPresent(badgeCards :: add);

        // 第一次获得徽章
        if (scoreCardList.size() == 1 && !containsBadge(badgeCardList, Badge.FIRST_WON)) {
            BadgeCard firstWonBadge = giveBadgeToUser(Badge.FIRST_WON, userId);
            badgeCards.add(firstWonBadge);
        }
        return badgeCards;
    }

    /**
     * 包含徽章
     *
     * @param badgeCardList 徽章卡列表
     * @param badge         徽章
     *
     * @return boolean
     */
    private boolean containsBadge(final List<BadgeCard> badgeCardList, final Badge badge) {
        return badgeCardList.stream().anyMatch(b -> b.getBadge().equals(badge));
    }

    /**
     * 给用户的徽章
     *
     * @param badge  徽章
     * @param userId 用户id
     *
     * @return {@code BadgeCard}
     */
    private BadgeCard giveBadgeToUser(final Badge badge, final Long userId) {
        BadgeCard badgeCard = new BadgeCard(userId, badge);
        badgeCardRepository.save(badgeCard);
        log.info("User with id {} won a new badge: {}", userId, badge);
        return badgeCard;
    }

    /**
     * 检查和基于分数给徽章
     *
     * @param badgeCardList       徽章卡列表
     * @param bronzeMultiplicator 青铜乘数
     * @param totalScore          总分
     * @param scoreThreshold      分数阈值
     * @param userId              用户id
     *
     * @return {@code Optional<BadgeCard>}
     */
    private Optional<BadgeCard> checkAndGiveBadgeBasedOnScore(final List<BadgeCard> badgeCardList, final Badge bronzeMultiplicator,
                                                              final int totalScore, final int scoreThreshold, final Long userId) {
        if (totalScore >= scoreThreshold && !containsBadge(badgeCardList, bronzeMultiplicator)) {
            return Optional.of(giveBadgeToUser(bronzeMultiplicator, userId));
        }
        return Optional.empty();
    }
}
