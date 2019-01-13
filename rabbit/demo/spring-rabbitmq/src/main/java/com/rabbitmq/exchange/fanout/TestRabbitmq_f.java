package com.rabbitmq.exchange.fanout;

import java.util.HashMap;

/** 测试：exchange的fanout模式测试

 */
public class    TestRabbitmq_f {
    public static void main(String[] args){
        String exchangeName = "exchangeName";
        String queueName = "queue";
        try{
            //=========================消费者：一个exchang绑定多个queue=============================//
            //从下面两个消费者可以看出来，两个消费者可以从不同的queue中获取相同的信息
            //因为这两个queue都和exchange进行了绑定，而fanmout模式中生产者会将消息发送给exchange，而exchange
            //会将消息发送到所有与其绑定的queue中
            /*Consumer_f consumer = new Consumer_f("queu3",exchangeName);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();

            Consumer_f1 consumer_1 = new Consumer_f1("queue2", exchangeName);
            Thread thread1 = new Thread(consumer_1);
            thread1.start();*/
            //===================================================================//
            //=====================消费者：一个queue绑定多个exchang========================//
//            Consumer_f consumer_2 = new Consumer_f("queue",exchangeName);
//            Thread consumerThread_2 = new Thread(consumer_2);
//            consumerThread_2.start();
//
//            Consumer_f1 consumer_3 = new Consumer_f1("queue", exchangeName + "_1");
//            Thread thread_3 = new Thread(consumer_3);
//            thread_3.start();
            //===================================================================//
            Producer_f producer = new Producer_f(exchangeName);
            Producer_f producer_1 = new Producer_f(exchangeName + "_1");
//            Producer_02 producer_02 = new Producer_02("queue");
            for (int i = 0; i < 100; i++){
                HashMap message = new HashMap();
                message.put("message number", "producer_f:" + i);
                producer.sendMessage(message);
                HashMap message2 = new HashMap();
                message2.put("message number", "producer_1:" + i);
                producer_1.sendMessage(message2);
//                System.out.println("Message Number "+ i +" sent.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
