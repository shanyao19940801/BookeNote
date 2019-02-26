package com.mq.yaomq.config;

import com.mq.yaomq.params.FactoryParam;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

/**
 * @create by  单耀
 * @create date  2019/2/26
 */
public class MqConfigHelper {
    public MqConfigHelper() {
    }

    public static ConnectionFactory newCachingConnectionFactory(FactoryParam apiMqConfigParam, String virtualHost) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(apiMqConfigParam.getUrl());
        connectionFactory.setUsername(apiMqConfigParam.getUsername());
        connectionFactory.setPassword(apiMqConfigParam.getPasspword());
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setChannelCacheSize(25);
        return connectionFactory;
    }
}
