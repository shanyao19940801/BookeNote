package com.mq.yaomq.config;

import com.mq.yaomq.listener.MyListener;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean
    public AbstractMessageListenerContainer commonListenerContainer (
            @Value("${yao.rabbitmq.queue}") String queue,
            @Value("${yao.rabbitmq.exchange}") String exchange,
            MyListener myListener
//                @Qualifier(CONNECTION_FACTORY) ConnectionFactory connectionFactory
    ) {
        return new AbstractMessageListenerContainer() {
            @Override
            protected void doInitialize() throws Exception {

            }
            @Override
            protected void doShutdown() {

            }
        };
    }
}
