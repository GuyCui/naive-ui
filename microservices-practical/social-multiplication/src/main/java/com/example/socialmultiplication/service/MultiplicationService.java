package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;

import java.util.List;

/**
 * @author guycui
 */
public interface MultiplicationService {
    /**
     * 通过id获取结果
     *
     * @param resultId 结果id
     *
     * @return {@code MultiplicationResultAttempt}
     */
    MultiplicationResultAttempt getResultById(final Long resultId);

    /**
     * 创建随机乘法
     *
     * @return {@link Multiplication}
     */
    Multiplication createRandomMultiplication();

    /**
     * 检查尝试
     *
     * @param resultAttempt 结果尝试
     *
     * @return boolean
     */
    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

    List<MultiplicationResultAttempt> getStatsForUser(String userAlias);
}
