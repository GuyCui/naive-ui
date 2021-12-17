package com.example.socialmultiplication.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** @author Guy Cui */
@Component
public class EventDispatcher {
  private final RabbitTemplate rabbitTemplate;
  private final String multiplicationSolvedExchange;
  private final String multiplicationSolvedRoutingKey;

  @Autowired
  EventDispatcher(
      final RabbitTemplate rabbitTemplate,
      @Value("${multiplication.exchange}") final String multiplicationExchange,
      @Value("${multiplication.solved.key}") final String multiplicationSolvedRoutingKey) {
    this.rabbitTemplate = rabbitTemplate;
    this.multiplicationSolvedExchange = multiplicationExchange;
    this.multiplicationSolvedRoutingKey = multiplicationSolvedRoutingKey;
  }

  public void send(final MultiplicationSolvedEvent multiplicationSolvedEvent) {
    rabbitTemplate.convertAndSend(
        multiplicationSolvedExchange, multiplicationSolvedRoutingKey, multiplicationSolvedEvent);
  }
}
