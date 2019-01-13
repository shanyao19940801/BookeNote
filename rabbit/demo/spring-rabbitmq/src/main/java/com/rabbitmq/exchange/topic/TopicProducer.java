package com.rabbitmq.exchange.topic;

import org.springframework.amqp.utils.SerializationUtils;

import java.io.Serializable;

public class TopicProducer extends TopicEndPoint {
    public TopicProducer(String exchangeName) throws Exception {
        super("queue_topic", exchangeName);
    }

    public void sendMessage(Serializable object, String routingKey) throws Exception {
        channel.basicPublish(exchangeName,routingKey, null, SerializationUtils.serialize(object));
    }
}
