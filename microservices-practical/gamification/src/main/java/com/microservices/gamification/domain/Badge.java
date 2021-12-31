package com.microservices.gamification.domain;

/**
 * 游戏中可能获得的徽章枚举类
 *
 * @author Guy Cui
 */
public enum Badge {
    /**
     * 青铜乘数
     */
    BRONZE_MULTIPLICATOR,
    /**
     * 银乘数
     */
    SILVER_MULTIPLICATOR,
    /**
     * 黄金乘数
     */
    GOLD_MULTIPLICATOR,

    /**
     * 第一次尝试
     */// other badges won for different conditions
    FIRST_ATTEMPT,
    /**
     * 第一次赢了
     */
    FIRST_WON,
    /**
     * 幸运数字
     */
    LUCKY_NUMBER
}
