package com.example.socialmultiplication.service;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import com.example.socialmultiplication.doMain.User;
import com.example.socialmultiplication.event.EventDispatcher;
import com.example.socialmultiplication.event.MultiplicationSolvedEvent;
import com.example.socialmultiplication.repository.MultiplicationResultAttemptRepository;
import com.example.socialmultiplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
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
  private final EventDispatcher eventDispatcher;

  @Autowired
  public MultiplicationServiceImpl(
      final RandomGeneratorService randomGeneratorService,
      final MultiplicationResultAttemptRepository attemptRepository,
      final UserRepository userRepository,
      final EventDispatcher eventDispatcher) {
    this.randomGeneratorService = randomGeneratorService;
    this.attemptRepository = attemptRepository;
    this.userRepository = userRepository;
    this.eventDispatcher = eventDispatcher;
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

    // Check if the user already for that attempts
    Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());

    // Avoids 'hack' attempts
    Assert.isTrue(!resultAttempt.isCorrect(), "you can't send an attempt marked as correct!");

    // Check if it's correct
    boolean correct =
        resultAttempt.getResultAttempt()
            == resultAttempt.getMultiplication().getFactorA()
                * resultAttempt.getMultiplication().getFactorB();

    // Creates a copy, now setting the 'correct' field accordingly
    MultiplicationResultAttempt checkedAttempt =
        new MultiplicationResultAttempt(
            resultAttempt.getUser(),
            resultAttempt.getMultiplication(),
            resultAttempt.getResultAttempt(),
            correct);
    // Stores the attempt
    attemptRepository.save(checkedAttempt);
    // Communicates the result via Event
    eventDispatcher.send(
        new MultiplicationSolvedEvent(
            checkedAttempt.getId(), checkedAttempt.getUser().getId(), checkedAttempt.isCorrect()));
    // Returns the result
    return correct;
  }

  /**
   * @author [Cui Guy] @Description: [获得用户的统计数据] @Param [@param userAlias 用户别名] @Return [@return
   *     {@link List<MultiplicationResultAttempt> }] @Date [2021/12/13]
   * @update: [序号][2021/12/13] [Cui Guy][变更描述]
   */
  @Override
  public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
    return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
  }
}
