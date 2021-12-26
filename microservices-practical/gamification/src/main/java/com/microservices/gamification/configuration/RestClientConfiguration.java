package com.microservices.gamification.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @className: RestClientConfiguration
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/26
 **/
@Configuration
public class RestClientConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
