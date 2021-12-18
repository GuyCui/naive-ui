package com.microservices.gamification.service;

import com.microservices.gamification.domain.GameStats;

/**
 * 游戏服务
 *
 * @author Guy Cui
 */
public interface GameService {
    /**
     * 用户的新尝试
     *
     * @param userId    用户id
     * @param attemptId 尝试id
     * @param correct   正确的
     *
     * @return {@code GameStats}
     */
    GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct);

    /**
     * 检索用户统计
     *
     * @param userId 用户id
     *
     * @return {@code GameStats}
     */
    GameStats retrieveStatsForUser(Long userId);
}
