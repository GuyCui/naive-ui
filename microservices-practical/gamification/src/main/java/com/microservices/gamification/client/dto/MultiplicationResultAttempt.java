package com.microservices.gamification.client.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.microservices.gamification.client.MultiplicationResultAttemptDeserializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @className: MultiplicationResultAttempt
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/24
 **/
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = MultiplicationResultAttemptDeserializer.class)
public final class MultiplicationResultAttempt {
    private final String userAlias;

    private final int multiplicationFactorA;

    private final int multiplicationFactorB;

    private final int resultAttempt;

    private final boolean correct;

    MultiplicationResultAttempt() {
        userAlias = null;
        multiplicationFactorA = -1;
        multiplicationFactorB = -1;
        resultAttempt = -1;
        correct = false;
    }
}
