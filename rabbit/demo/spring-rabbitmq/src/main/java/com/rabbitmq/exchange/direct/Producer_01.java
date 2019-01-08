package com.rabbitmq.exchange.direct;


import org.springframework.amqp.utils.SerializationUtils;

import java.io.Serializable;

public class Producer_01 extends EndPoint {

    public Producer_01(String QueueName) throws Exception {
        super(QueueName);
    }

    public void sendMessage(Serializable object) throws Exception {
        channel.basicPublish("",QueueName, null, SerializationUtils.serialize(object));
    }
}
