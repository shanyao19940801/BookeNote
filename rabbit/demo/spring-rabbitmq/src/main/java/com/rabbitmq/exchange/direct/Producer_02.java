package com.rabbitmq.exchange.direct;

import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Producer_02 extends EndPoint {
    public Producer_02(String QueueName) throws Exception {
        super(QueueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("", QueueName, null, SerializationUtils.serialize(object));
    }

}
