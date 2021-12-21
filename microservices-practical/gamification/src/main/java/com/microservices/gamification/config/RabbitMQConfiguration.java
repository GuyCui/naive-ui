package com.microservices.gamification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpoint;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

/**
 * @className: RabbitMQConfiguration
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/21
 **/
@Configuration
public class RabbitMQConfiguration implements RabbitListenerConfigurer {

    @Bean
    public TopicExchange multiplicationExchange(@Value("${multiplication.exchange}") final String exchange) {
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue gamificationQueue(@Value("${multiplication.queue}") final String queueName) {
        return new Queue(queueName, false);
    }

    @Bean
    Binding binding(final Queue queue, final TopicExchange exchange, @Value("${multiplication.anything.routing key}") final String routingKey) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(mappingJackson2MessageConverter());
        return factory;
    }

    /**
     * Callback allowing a {@link RabbitListenerEndpointRegistry
     * RabbitListenerEndpointRegistry} and specific {@link RabbitListenerEndpoint
     * RabbitListenerEndpoint} instances to be registered against the given
     * {@link RabbitListenerEndpointRegistrar}. The default
     * {@link RabbitListenerContainerFactory RabbitListenerContainerFactory}
     * can also be customized.
     *
     * @param registrar the registrar to be configured
     */
    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
}
