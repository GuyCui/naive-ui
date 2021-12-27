package com.microservices.gamification.domain;

/**
 * 游戏中可能获得的徽章枚举类
 *
 * @author Guy Cui
 */
public enum Badge {
    BRONZE_MULTIPLICATOR, SILVER_MULTIPLICATOR, GOLD_MULTIPLICATOR,

    // other badges won for different conditions
    FIRST_ATTEMPT, FIRST_WON, LUCKY_NUMBER
}
