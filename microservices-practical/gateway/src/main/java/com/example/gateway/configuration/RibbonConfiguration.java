package com.example.gateway.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;

/**
 * 丝带配置
 *
 * @author Guy Cui
 * @className: RibbonConfiguration
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2022/1/11
 * @date 2022/01/11
 */
public class RibbonConfiguration {
    @Bean
    public IPing ribbonPing(final IClientConfig config) {
        return new PingUrl(false, "/health");
    }

    @Bean
    public IRule ribbonRule(final IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
