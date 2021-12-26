package com.microservices.gamification.client;

import com.microservices.gamification.client.dto.MultiplicationResultAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @className: MultiplicationResultAttemptClientImpl
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/26
 **/
@Component
public class MultiplicationResultAttemptClientImpl implements MultiplicationResultAttemptClient {
    private final RestTemplate restTemplate;
    private final String multiplicationHost;

    @Autowired
    public MultiplicationResultAttemptClientImpl(final RestTemplate restTemplate, @Value("${multiplicationHost}") final String multiplicationHost) {
        this.multiplicationHost = multiplicationHost;
        this.restTemplate = restTemplate;
    }

    /**
     * 检索效果倍增尝试通过id
     *
     * @param multiplicationId 乘法id
     *
     * @return {@code MultiplicationResultAttempt}
     */
    @Override
    public MultiplicationResultAttempt retrieveMultiplicationResultAttemptById(Long multiplicationId) {
        return restTemplate.getForObject(multiplicationHost + "/results" + multiplicationId, MultiplicationResultAttempt.class);
    }
}
