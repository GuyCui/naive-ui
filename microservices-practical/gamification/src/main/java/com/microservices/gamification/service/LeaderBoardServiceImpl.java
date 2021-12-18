package com.microservices.gamification.service;

import com.microservices.gamification.domain.GameStats;
import com.microservices.gamification.domain.LeaderBoardRow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排行榜服务impl
 *
 * @author Guy Cui
 */
@Service
@Slf4j
public class LeaderBoardServiceImpl implements GameService {
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
    public GameStats retrieveStatsForUser(Long userId) {
        return null;
    }

    /**
     * 得到卡伦牌排行榜
     *
     * @return {@code List<LeaderBoardRow>}
     */
    public List<LeaderBoardRow> getCurrenLeaderBoard() {
        return null;
    }
}
