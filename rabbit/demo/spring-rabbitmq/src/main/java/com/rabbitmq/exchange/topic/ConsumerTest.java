package com.rabbitmq.exchange.topic;

public class ConsumerTest {
    public static void main(String[] args) throws Exception {
        String exchangeName = "amq.topic";
        String queueName = "queue_topic";
        ConsumerWithKey consumer_1 = new ConsumerWithKey(queueName, exchangeName, "kernal.*");
        Thread thread_1 = new Thread(consumer_1);
        thread_1.start();
        ConsumerWithKey consumer_2 = new ConsumerWithKey(queueName + "_to", exchangeName, "shanyao.*");
        Thread thread_2 = new Thread(consumer_2);
        thread_2.start();
    }

}
