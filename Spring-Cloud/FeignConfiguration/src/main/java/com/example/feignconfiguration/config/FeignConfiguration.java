package com.example.feignconfiguration.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: FeignConfiguration
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/30
 **/
@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract () {
        return new feign.Contract.Default();
    }
}
