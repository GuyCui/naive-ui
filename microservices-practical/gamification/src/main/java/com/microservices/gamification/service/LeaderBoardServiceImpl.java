package com.microservices.gamification.service;

import com.microservices.gamification.domain.LeaderBoardRow;
import com.microservices.gamification.repository.ScoreCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 排行榜服务impl
 *
 * @author Guy Cui
 */
@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {
    private final ScoreCardRepository scoreCardRepository;

    public LeaderBoardServiceImpl(final ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    /**
     * 得到当前排行榜
     *
     * @return {@code List<LeaderBoardRow>}
     */
    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        return scoreCardRepository.findFirst10();
    }
}
