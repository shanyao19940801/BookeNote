package com.rabbitmq.exchange.fanout;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Consumer_f extends EndPoint_f implements Runnable, Consumer {
    public Consumer_f(String QueueName, String exchangeName) throws Exception {
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
        System.out.println("Consumer_f "+s +" registered");
    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(bytes);
//        System.out.println(map.get("1"));
        System.out.println("Consumer_f get Message Number "+ map.get("message number") + " received.");
    }

    public void run() {
        try {
            //把队列绑定到路由上
            channel.queueDeclare(QueueName, false, false, false, null);
            channel.queueBind(QueueName,"exchangeName","");
            channel.basicConsume(QueueName, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
