package com.example.feignlogger;

import com.example.feignlogger.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @className: MyFeignClient
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/1
 **/
@FeignClient(contextId = "feignClient", name = "service-producer", configuration = FeignConfiguration.class)
public interface MyFeignClient {
    /**
     * 你好
     *
     * @return {@code String}
     */
    @GetMapping(value = "/hello")
    public String hello();
}
