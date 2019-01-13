package com.rabbitmq.exchange.fanout;


import org.springframework.amqp.utils.SerializationUtils;

import java.io.Serializable;

public class Producer_f extends EndPoint_f {

    public Producer_f(String exchangeName) throws Exception {
        super("tasks",exchangeName);

    }

    public void sendMessage(Serializable object) throws Exception {
        channel.basicPublish(exchangeName,"", null, SerializationUtils.serialize(object));
    }
}
