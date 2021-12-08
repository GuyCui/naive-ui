package com.example.socialmultiplication.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @className: RandomGeneratorServiceImpl
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/8
 */
@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {
  /** 最小的因素 */
  static final int MINIMUM_FACTOR = 11;
  /** 最大的因素 */
  static final int MAXIMUM_FACTOR = 99;

  @Override
  public int generateRandomFactor() {
    return new Random().nextInt((MAXIMUM_FACTOR - MINIMUM_FACTOR) + 1) + MINIMUM_FACTOR;
  }
}
