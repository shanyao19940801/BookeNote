package com.mq.yaomq.factory;


import com.mq.yaomq.config.MqConfigHelper;
import com.mq.yaomq.params.FactoryParam;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

public class FactoryUtil {
    public static ConnectionFactory getConnectionFactory() {
        FactoryParam configParam = new FactoryParam();
        configParam.setUrl("47.100.211.121:5672");
        configParam.setUsername("shanyao");
        configParam.setPasspword("123456");
        return MqConfigHelper.newCachingConnectionFactory(configParam, "shanyao_001_vhost");
        /*ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.100.211.121");
        factory.setUsername("shanyao");
        factory.setPassword("123456");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        return factory;*/
    }
}
