package com.rabbitmq.workqueue;

public class SenderTest {

    public static void main(String[] args) throws Exception {

        Sender sender = new Sender("S");
        sender.work();
    }
}
