package com.rabbitmq.exchange.direct;

public class ConsumerTest {
    public static void main(String[] args) throws Exception {
        Consumer_1 consumer_1 = new Consumer_1("queue");
        Thread thread1 = new Thread(consumer_1);
        thread1.start();
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

    }
}
