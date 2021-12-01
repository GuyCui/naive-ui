package com.example.feignlogger.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: FeignConfiguration
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/1
 **/
@Configuration
public class FeignConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
