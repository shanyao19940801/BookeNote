package com.rabbitmq.exchange.topic;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.amqp.utils.SerializationUtils;

import java.io.IOException;

public class TopicConsumer extends TopicEndPoint implements Runnable,Consumer {


    public TopicConsumer(String QueueName, String exchangeName) throws Exception {
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
        String msg = (String) SerializationUtils.deserialize(bytes);
        System.out.println("receive:" + msg);
//        Map map = (HashMap) SerializationUtils.deserialize(bytes);
//        System.out.println(map.get("1"));
//        System.out.println("Consumer_f1 get Message Number "+ map.get("message number") + " received.");

    }

    public void run() {
        try {
            channel.queueDeclare(queueName, false, false, false, null);
            channel.basicConsume(queueName, true, this);
            //绑定queue的时候会制定一个routingKey,这个routingKey可以匹配任何routingKey以critical结尾的queue
            channel.queueBind(queueName,exchangeName,"*.critical");
            System.out.println("11111");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
