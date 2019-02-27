package com.mq.yaomq.config;

import com.mq.yaomq.listener.MyListener;
import com.mq.yaomq.params.FactoryParam;
import com.mq.yaomq.params.MqListenParam;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
@DependsOn(value = CommonConfig.COMMON_CONFIG_DEPENDSON)
//@PropertySource("classpath:local/config.properties")
public class MqConfig {
    private final static String CONNECTION_FACTORY = "connectionFactory";
    private static final String MQ_CONFIG_PARAM = "mqConfigParam";

    @Bean (name = MQ_CONFIG_PARAM)
    public FactoryParam apiMqConfigParam(
            @Value("${rabbitmq.url}") String url,
            @Value("${rabbitmq.username}") String username,
            @Value("${rabbitmq.password}") String password,
            @Value("${rabbitmq.vhost}") String virtualHost
    ){
        FactoryParam configParam = new FactoryParam();
        configParam.setUrl(url);
        configParam.setUsername(username);
        configParam.setPasspword(password);
        configParam.setVhost(virtualHost);
        return configParam;
    }

    @Bean(name = CONNECTION_FACTORY)
    public ConnectionFactory connectFactory(
            @Qualifier(MqConfig.MQ_CONFIG_PARAM) FactoryParam mqConfigParam,
            @Value("${rabbitmq.vhost}") String virtualHost
    ) {
        System.out.println(mqConfigParam);
        return MqConfigHelper.newCachingConnectionFactory(mqConfigParam, virtualHost);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @Bean
    public AbstractMessageListenerContainer commonListenerContainer (
            @Value("${yao.rabbitmq.queue}") String queueName,
            @Value("${yao.rabbitmq.exchange}") String exchange,
            MyListener myListener,
            @Qualifier(CONNECTION_FACTORY) ConnectionFactory connectionFactory
    ) {
        MqListenParam listenParam = new MqListenParam();
        listenParam.setQueueName(queueName);
        listenParam.setRoutingKey("yao_mq_v1.#");
        listenParam.setTopicExchange(exchange);
        Queue queue = new Queue(queueName);

        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setConcurrentConsumers(1);
        listenerContainer.setChannelTransacted(true);
        listenerContainer.setQueues(new Queue[]{queue});
        listenerContainer.setMessageListener(myListener);
        return listenerContainer;
    }
}
