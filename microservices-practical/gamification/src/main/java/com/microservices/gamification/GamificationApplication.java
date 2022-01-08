package com.microservices.gamification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 游戏化应用程序
 *
 * @author Guy Cui
 * @date 2022/01/08
 */
@SpringBootApplication
@EnableEurekaClient
public class GamificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamificationApplication.class, args);
    }

}
