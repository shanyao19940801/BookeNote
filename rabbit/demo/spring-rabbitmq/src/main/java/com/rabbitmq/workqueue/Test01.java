package com.rabbitmq.workqueue;

public class Test01 {

    public static void main(String[] args) throws Exception {
        Receiver recv1 = new Receiver("A", 200);
        recv1.work();
        Receiver recv2 = new Receiver("B", 200);
        recv2.work();
        Sender sender = new Sender("S");
        sender.work();
    }
}
