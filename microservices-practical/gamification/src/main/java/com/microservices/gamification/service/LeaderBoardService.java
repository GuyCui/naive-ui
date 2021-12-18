package com.microservices.gamification.service;

import com.microservices.gamification.domain.LeaderBoardRow;

import java.util.List;

/**
 * 排行榜服务
 *
 * @author Guy Cui
 */
public interface LeaderBoardService {
    /**
     * 得到当前排行榜
     *
     * @return {@code List<LeaderBoardRow>}
     */
    List<LeaderBoardRow> getCurrentLeaderBoard();
}
