package com.microservices.gamification.controller;

import com.microservices.gamification.domain.LeaderBoardRow;
import com.microservices.gamification.service.LeaderBoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @className: LeaderBoardController
 * @description: Rest API 暴露一个调用端点，检索当前的排行榜。
 * @author: GuyCui
 * @date: 2021/12/20
 **/
@RestController
@RequestMapping("/leaders")
public class LeaderBoardController {
    private final LeaderBoardService leaderBoardService;

    public LeaderBoardController(final LeaderBoardService leaderBoardService) {
        this.leaderBoardService = leaderBoardService;
    }

    @GetMapping
    public List<LeaderBoardRow> gerLeaderBoard() {
        return leaderBoardService.getCurrentLeaderBoard();
    }
}
