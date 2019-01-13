package com.rabbitmq.workqueue;

public class ReceiverTest {
    public static void main(String[] args) throws Exception {

        Receiver recv1 = new Receiver("A", 200);
        recv1.work();
        Receiver recv2 = new Receiver("B", 200);
        recv2.work();
    }
}
