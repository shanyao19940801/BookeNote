package com.rabbitmq.exchange.fanout;

import java.util.HashMap;

public class ProducerTest {
    public static void main(String[] args) throws Exception {
        String exchangeName = "exchangeName";
        Producer_f producer = new Producer_f(exchangeName);
        Producer_f producer_1 = new Producer_f(exchangeName + "_1");
//            Producer_02 producer_02 = new Producer_02("queue");
        for (int i = 0; i < 10; i++){
            HashMap message = new HashMap();
            message.put("message number ", "producer_f:" + i);
            producer.sendMessage(message);
            HashMap message2 = new HashMap();
            message2.put("message number", "producer_1:" + i);
            producer_1.sendMessage(message2);
//                System.out.println("Message Number "+ i +" sent.");
        }
    }
}
