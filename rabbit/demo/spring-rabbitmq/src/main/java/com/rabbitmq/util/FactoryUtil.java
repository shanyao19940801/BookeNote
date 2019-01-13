package com.rabbitmq.util;

import com.rabbitmq.client.ConnectionFactory;

public class FactoryUtil {
    public static ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.100.211.121");
        factory.setUsername("shanyao");
        factory.setPassword("123456");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        return factory;
    }
}
