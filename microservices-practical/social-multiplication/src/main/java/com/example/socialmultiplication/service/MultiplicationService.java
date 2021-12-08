package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;

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
}
