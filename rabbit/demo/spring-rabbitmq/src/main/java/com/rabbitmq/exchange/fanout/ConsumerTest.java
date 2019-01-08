package com.rabbitmq.exchange.fanout;

public class ConsumerTest {
    public static void main(String[] args) throws Exception {
        String exchangeName = "exchangeName";
        Consumer_f consumer_2 = new Consumer_f("tasks",exchangeName);
        Thread consumerThread_2 = new Thread(consumer_2);
        consumerThread_2.start();
    }
}
