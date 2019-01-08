package com.rabbitmq.exchange.fanout;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Consumer_f1 extends EndPoint_f implements Runnable, Consumer {
    public Consumer_f1(String QueueName, String exchangeName) throws Exception {
        super(QueueName, exchangeName);
    }

    public void handleConsumeOk(String s) {

    }

    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(bytes);
//        System.out.println(map.get("1"));
        System.out.println("Consumer_f1 get Message Number "+ map.get("message number") + " received.");
    }

    public void run() {
        //把队列绑定到路由上
        try {
            channel.queueDeclare(QueueName, false, false, false, null);
            channel.queueBind(QueueName, exchangeName, "");
            channel.basicConsume(QueueName, true, this);
        } catch (Exception e) {

        }
    }
}
