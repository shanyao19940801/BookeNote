package com.rabbitmq.exchange.direct;

import java.util.HashMap;

/** 测试：
 * 多个生产者往同一个队列中添加信息
 * 多个消费者从同一个队列中获取消息
 */
public class TestRabbitmq {
    public static void main(String[] args){
        try{
            QueueConsumer consumer = new QueueConsumer("queue");
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();

            Consumer_1 consumer_1 = new Consumer_1("queue");
            Thread thread1 = new Thread(consumer_1);
            thread1.start();

            Producer_01 producer = new Producer_01("queue");
            Producer_02 producer_02 = new Producer_02("queue");


            for (int i = 0; i < 10; i++){
                HashMap message = new HashMap();
                message.put("message number", "producer_1:" + i);
                producer.sendMessage(message);
                HashMap message2 = new HashMap();
                message2.put("message number", "producer_2:" + i);
                producer_02.sendMessage(message2);
//                System.out.println("Message Number "+ i +" sent.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
