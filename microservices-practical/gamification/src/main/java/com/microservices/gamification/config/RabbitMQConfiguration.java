package com.microservices.gamification.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
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

    /**
     * 乘法交换
     *
     * @param exchange 交换
     *
     * @return {@code TopicExchange}
     */
    @Bean
    public TopicExchange multiplicationExchange(@Value("${multiplication.exchange}") final String exchange) {
        return new TopicExchange(exchange);
    }

    /**
     * 游戏化队列
     *
     * @param queueName 队列名称
     *
     * @return {@code Queue}
     */
    @Bean
    public Queue gamificationMultiplicationQueue(@Value("${multiplication.queue}") final String queueName) {
        return new Queue(queueName, false);
    }

    /**
     * 绑定
     *
     * @param queue      队列
     * @param exchange   交换
     * @param routingKey 路由关键
     *
     * @return {@code Binding}
     */
    @Bean
    Binding binding(final Queue queue, final TopicExchange exchange, @Value("${multiplication.anything.routing-key}") final String routingKey) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    /**
     * 映射jackson2消息转换器
     *
     * @return {@code MappingJackson2MessageConverter}
     */
    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    /**
     * 消息处理程序方法工厂
     *
     * @return {@code MessageHandlerMethodFactory}
     */
    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(mappingJackson2MessageConverter());
        return factory;
    }

    /**
     * 兔子配置监听器
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
