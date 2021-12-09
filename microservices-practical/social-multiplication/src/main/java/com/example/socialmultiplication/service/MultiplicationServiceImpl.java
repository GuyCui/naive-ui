package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @className: MultiplicationServiceImpl
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/8
 **/
public class MultiplicationServiceImpl implements MultiplicationService {

    private final RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        return resultAttempt.getResultAttempt() == resultAttempt.getMultiplication().getFactorA() * resultAttempt.getMultiplication().getFactorB();
    }
}
