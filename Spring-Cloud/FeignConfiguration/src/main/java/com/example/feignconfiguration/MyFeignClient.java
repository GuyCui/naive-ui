package com.example.feignconfiguration;

import com.example.feignconfiguration.config.FeignConfiguration;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
    contextId = "feignClient",
    name = "service-provider",
    configuration = FeignConfiguration.class)
public interface MyFeignClient {
  @RequestLine("GET /hello")
  public String hello();
}
