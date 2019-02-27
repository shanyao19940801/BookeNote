package com.mq.yaomq.config;

import com.mq.yaomq.listener.MyListener;
import com.mq.yaomq.params.FactoryParam;
import com.mq.yaomq.params.MqListenParam;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
    private static final String MQ_LISTEN_PARAM = "listenParam";

    @Bean (name = MQ_CONFIG_PARAM)
    public FactoryParam mqConfigParam(
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

    @Bean(name = MQ_LISTEN_PARAM)
    public MqListenParam listenParam(@Value("${yao.rabbitmq.queue}") String queueName,
                                     @Value("${yao.rabbitmq.exchange}") String exchange
    ) {
        MqListenParam listenParam = new MqListenParam();
        listenParam.setQueueName(queueName);
        listenParam.setRoutingKey("yao_mq_v1.#");
        listenParam.setTopicExchange(exchange);
        return listenParam;
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
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory,
                                   @Qualifier(MQ_LISTEN_PARAM)MqListenParam mqListenParam
    ) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        Queue queue = new Queue(mqListenParam.getQueueName());
        rabbitAdmin.declareQueue(queue);
        TopicExchange topicExchange = new TopicExchange(mqListenParam.getTopicExchange(), true, false);
        rabbitAdmin.declareExchange(topicExchange);
        Binding binding = BindingBuilder.bind(queue).to(topicExchange).with(mqListenParam.getRoutingKey());
        rabbitAdmin.declareBinding(binding);
        return rabbitAdmin;
    }

    @Bean
    public AbstractMessageListenerContainer commonListenerContainer (
            @Qualifier(MQ_LISTEN_PARAM)MqListenParam mqListenParam,
            MyListener myListener,
            @Qualifier(CONNECTION_FACTORY) ConnectionFactory connectionFactory
    ) {

        Queue queue = new Queue(mqListenParam.getQueueName());

        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setConcurrentConsumers(1);
        listenerContainer.setChannelTransacted(true);
        listenerContainer.setQueues(new Queue[]{queue});
        listenerContainer.setMessageListener(myListener);
        return listenerContainer;
    }
}
