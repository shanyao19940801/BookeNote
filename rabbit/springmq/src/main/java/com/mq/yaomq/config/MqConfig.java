package com.mq.yaomq.config;

import com.mq.yaomq.listener.MyListener;
import com.mq.yaomq.params.FactoryParam;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class MqConfig {
    private final static String CONNECTION_FACTORY = "connectionFactory";
    private static final String MQ_CONFIG_PARAM = "mqConfigParam";

    @Bean (name = MQ_CONFIG_PARAM)
    public FactoryParam apiMqConfigParam(
            @Value("${rabbitmq.url}") String url,
            @Value("${rabbitmq.username}") String username,
            @Value("${rabbitmq.password}") String password
    ){
        FactoryParam configParam = new FactoryParam();
        configParam.setUrl(url);
        configParam.setUsername(username);
        configParam.setPasspword(password);
        return configParam;
    }
    @Bean(name = CONNECTION_FACTORY)
    public ConnectionFactory connectFactory(
            @Qualifier(MqConfig.MQ_CONFIG_PARAM) FactoryParam apiMqConfigParam,
            @Value("${commentsvc.rabbitmq.vhost}") String virtualHost
    ) {

        return MqConfigHelper.newCachingConnectionFactory(apiMqConfigParam, virtualHost);
    }

    @Bean
    public AbstractMessageListenerContainer commonListenerContainer (
            @Value("${yao.rabbitmq.queue}") String queue,
            @Value("${yao.rabbitmq.exchange}") String exchange,
            MyListener myListener,
            @Qualifier(CONNECTION_FACTORY) ConnectionFactory connectionFactory
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
