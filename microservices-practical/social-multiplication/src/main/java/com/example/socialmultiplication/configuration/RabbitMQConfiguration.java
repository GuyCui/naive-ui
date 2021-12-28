package com.example.socialmultiplication.configuration;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ configuration.
 *
 * @author GuyCui
 */
@Configuration
public class RabbitMQConfiguration {

  @Bean
  public org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    //设置服务地址
    connectionFactory.setHost("82.156.68.175");
    //端口
    connectionFactory.setPort(5672);
    //设置账号信息，用户名、密码、vhost
    //connectionFactory.setVirtualHost("testhost");
    connectionFactory.setUsername("admin");
    connectionFactory.setPassword("admin");

    return connectionFactory;
  }

  @Bean
  public TopicExchange multiplicationExchange(@Value("${multiplication.exchange}") final String exchangeName) {
    return new TopicExchange(exchangeName);
  }

  @Bean
  public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
