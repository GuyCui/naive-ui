package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;

/**
 * @author guycui
 */
public interface MultiplicationService {
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
     * @return boolean
     */
    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
