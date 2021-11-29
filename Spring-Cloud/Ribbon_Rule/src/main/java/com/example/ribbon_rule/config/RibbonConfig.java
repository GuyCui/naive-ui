package com.example.ribbon_rule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: RibbonConfig
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/29
 **/
@Configuration
@RibbonClient(name = "provider",configuration = RibbonClientConfiguration.class)
public class RibbonConfig {
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
