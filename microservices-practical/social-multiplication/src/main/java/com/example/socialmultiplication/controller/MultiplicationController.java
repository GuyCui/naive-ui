package com.example.socialmultiplication.controller;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: MultiplicationController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/10
 */
@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {
  private final MultiplicationService multiplicationService;

  @Autowired(required = false)
  public MultiplicationController(final MultiplicationService multiplication) {
    this.multiplicationService = multiplication;
  }

  @GetMapping("/random")
  Multiplication getRandomMultiplication() {
    return multiplicationService.createRandomMultiplication();
  }
}
