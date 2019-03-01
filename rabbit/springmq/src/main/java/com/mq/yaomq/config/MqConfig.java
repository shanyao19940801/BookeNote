package com.mq.yaomq.config;

import com.mq.yaomq.common.rabbit.AsyncEventMsgConvert;
import com.mq.yaomq.common.rabbit.AsyncRabbitRouteSender;
import com.mq.yaomq.common.rabbit.MqTopicExchangeSendBundleBuilder;
import com.mq.yaomq.listener.YaoListener;
import com.mq.yaomq.listener.EventListener;
import com.mq.yaomq.params.FactoryParam;
import com.mq.yaomq.params.MqListenParam;
import com.mq.yaomq.common.rabbit.MqTopicQueueListenBundleBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mq.yaomq.config.GeneralManagerConfig.NEW_ASYNC_EVENT_MSG_ASYNCSENDER;

@Configuration
//@DependsOn(value = CommonConfig.COMMON_CONFIG_DEPENDSON)
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
        listenParam.setExchangeName(exchange);
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

    @Bean(name = NEW_ASYNC_EVENT_MSG_ASYNCSENDER, initMethod = "start", destroyMethod = "stop")
    public AsyncRabbitRouteSender asyncEventRabbitSenderNew(
            @Value("${yao.async.event.rabbitmq.exchange}") String exchange,
            @Qualifier(CONNECTION_FACTORY) ConnectionFactory connectionFactory) {
        MqTopicExchangeSendBundleBuilder builder = new MqTopicExchangeSendBundleBuilder(
                exchange, new AsyncEventMsgConvert(), connectionFactory
        );
        MqTopicExchangeSendBundleBuilder.MqTopicExchangeSendBundle bundle = builder.buildBundle();

        AsyncRabbitRouteSender sender = new AsyncRabbitRouteSender();
        sender.setSenderName("asyncEventSender");
        sender.setThreadCount(3);
        sender.setAmqpTemplate(bundle.getRabbitTemplate());
        return sender;
    }



    @Bean
    public AbstractMessageListenerContainer commonListenerContainer (
            YaoListener myListener,
            @Value("${yao.rabbitmq.queue}") String queueName,
            @Value("${yao.rabbitmq.exchange}") String exchange,
            @Qualifier(CONNECTION_FACTORY) ConnectionFactory connectionFactory
    ) {

        MqListenParam listenParam = new MqListenParam();
        listenParam.setQueueName(queueName);
        listenParam.setRoutingKey("shan_mq_v1.#");
        listenParam.setExchangeName(exchange);
        MqTopicQueueListenBundleBuilder bundleBuilder = new MqTopicQueueListenBundleBuilder(listenParam, myListener, connectionFactory);
        MqTopicQueueListenBundleBuilder.MqTopicQueueListenBundle bundle = bundleBuilder.initBundle();
        return bundle.getListenerContainer();

    }

    @Bean("event")
    public AbstractMessageListenerContainer yourListener (
            @Value("${yao.async.event.rabbitmq.queue}") String queueName,
            @Value("${yao.async.event.rabbitmq.exchange}") String exchange,
            EventListener yourListener,
            @Qualifier(CONNECTION_FACTORY) ConnectionFactory connectionFactory
    ) {
        MqListenParam listenParam = new MqListenParam();
        listenParam.setQueueName(queueName);
        listenParam.setRoutingKey("yao_async_event_v1.#");
        listenParam.setExchangeName(exchange);
        MqTopicQueueListenBundleBuilder bundleBuilder = new MqTopicQueueListenBundleBuilder(listenParam, yourListener, connectionFactory);
        MqTopicQueueListenBundleBuilder.MqTopicQueueListenBundle bundle = bundleBuilder.initBundle();
        return bundle.getListenerContainer();
    }
}
