package com.example.socialmultiplication.controller;

import com.example.socialmultiplication.doMain.MultiplicationResultAttempt;
import com.example.socialmultiplication.service.MultiplicationService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: MultiplicationResultAttemptController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/10
 */
@RestController
@RequestMapping("/results")
public final class MultiplicationResultAttemptController {

  private final MultiplicationService multiplicationService;

  @Autowired(required = false)
  public MultiplicationResultAttemptController(MultiplicationService multiplicationService) {
    this.multiplicationService = multiplicationService;
  }

  @PostMapping
  ResponseEntity<MultiplicationResultAttempt> postResult(
      @RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
    boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
    MultiplicationResultAttempt attemptCopy =
        new MultiplicationResultAttempt(
            multiplicationResultAttempt.getUser(),
            multiplicationResultAttempt.getMultiplication(),
            multiplicationResultAttempt.getResultAttempt(),
            isCorrect);
    return ResponseEntity.ok(attemptCopy);
  }

  @RequiredArgsConstructor
  @NoArgsConstructor(force = true)
  @Getter
  static final class ResultResponse {
    private final boolean correct;
  }
}
