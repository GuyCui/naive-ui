package com.microservices.gamification.client;

import com.microservices.gamification.client.dto.MultiplicationResultAttempt;

/**
 * 乘法运算结果尝试客户
 *
 * @author Guy Cui
 * @className: MultiplicationResultAttemptClient
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/26
 * @date 2021/12/26
 */
public interface MultiplicationResultAttemptClient {
    /**
     * 检索效果倍增尝试通过id
     *
     * @param multiplicationId 乘法id
     *
     * @return {@code MultiplicationResultAttempt}
     */
    MultiplicationResultAttempt retrieveMultiplicationTesultAttemptById(final Long multiplicationId);
}
