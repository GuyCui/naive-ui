package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import com.example.socialmultiplication.doMain.User;
import com.example.socialmultiplication.repository.MultiplicationResultAttemptRepository;
import com.example.socialmultiplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @className: MultiplicationServiceImpl
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/8
 */
@Service
public class MultiplicationServiceImpl implements MultiplicationService {

  private final RandomGeneratorService randomGeneratorService;
  private final MultiplicationResultAttemptRepository attemptRepository;
  private final UserRepository userRepository;

  @Autowired
  public MultiplicationServiceImpl(
      final RandomGeneratorService randomGeneratorService,
      final MultiplicationResultAttemptRepository attemptRepository,
      final UserRepository userRepository) {
    this.randomGeneratorService = randomGeneratorService;
    this.attemptRepository = attemptRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Multiplication createRandomMultiplication() {
    int factorA = randomGeneratorService.generateRandomFactor();
    int factorB = randomGeneratorService.generateRandomFactor();
    return new Multiplication(factorA, factorB);
  }

  @Override
  @Transactional
  public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {

    Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());
    Assert.isTrue(!resultAttempt.isCorrect(), "you can't send an attempt marked as correct!");

    // Check if it's correct
    boolean correct =
        resultAttempt.getResultAttempt()
            == resultAttempt.getMultiplication().getFactorA()
                * resultAttempt.getMultiplication().getFactorB();
    // Avoids 'hack' attempts

    // Creates a copy, now setting the 'correct' field accordingly
    MultiplicationResultAttempt checkedAttempt =
        new MultiplicationResultAttempt(
            resultAttempt.getUser(),
            resultAttempt.getMultiplication(),
            resultAttempt.getResultAttempt(),
            correct);
    attemptRepository.save(checkedAttempt);
    // Returns the result
    return correct;
  }
}
