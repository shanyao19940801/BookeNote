package com.rabbit.topic;

import com.rabbit.util.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class Delete {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();
//        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
//        channel.queueDelete("tasks_1");
        channel.exchangeDelete("amq.rabbitmq.log");
    }
}
