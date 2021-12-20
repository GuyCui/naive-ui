package com.microservices.gamification.controller;

import com.microservices.gamification.domain.GameStats;
import com.microservices.gamification.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserStatsController
 * @description: 调用端点 返回分数和徽章
 * @author: GuyCui
 * @date: 2021/12/20
 **/
@RestController
@RequestMapping("/stats")
public class UserStatsController {
    private final GameService gameService;


    public UserStatsController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public GameStats getStatsForUser(@RequestParam("userId") final Long userId) {
        return gameService.retrieveStatsForUser(userId);
    }
}
