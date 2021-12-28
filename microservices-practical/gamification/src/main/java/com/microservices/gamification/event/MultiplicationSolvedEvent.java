package com.microservices.gamification.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 乘法解决事件
 * Event received when a multiplication has been solved in the system.
 * Provides some context information about the multiplication.
 *
 * @author cuimingzhi
 * @date 2021/12/28
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolvedEvent implements Serializable {

    private Long multiplicationResultAttemptId;
    private Long userId;
    private boolean correct;

}
