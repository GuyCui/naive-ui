package com.example.socialmultiplication.controller;

import com.example.socialmultiplication.doMain.Multiplication;
import com.example.socialmultiplication.service.MultiplicationService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequestMapping("/multiplications")
public class MultiplicationController {
    private final MultiplicationService multiplicationService;
    private final int serverPort;

    @Autowired(required = false)
    public MultiplicationController(final MultiplicationService multiplication, int serverPort) {
        this.multiplicationService = multiplication;
        this.serverPort = serverPort;
    }

    @GetMapping("/random")
    Multiplication getRandomMultiplication() {
        log.info("Generating a random multiplication from server @ {}", serverPort);
        return multiplicationService.createRandomMultiplication();
    }
}
