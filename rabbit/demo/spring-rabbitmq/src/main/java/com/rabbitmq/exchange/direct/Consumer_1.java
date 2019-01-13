package com.rabbitmq.exchange.direct;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Consumer_1 extends EndPoint implements Runnable, Consumer {
    public Consumer_1(String QueueName) throws Exception {
        super(QueueName);
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
        System.out.println("Consumer_1 "+s +" registered");
    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(bytes);
//        System.out.println(map.get("1"));
        System.out.println("Consumer_1 get Message Number "+ map.get("message number") + " received.");
    }

    public void run() {
        try {
            channel.basicConsume(QueueName, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
