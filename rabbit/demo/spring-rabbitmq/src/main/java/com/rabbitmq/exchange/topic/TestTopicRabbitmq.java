package com.rabbitmq.exchange.topic;

/** 测试：exchange的topic模式测试

 */
public class TestTopicRabbitmq {
    public static void main(String[] args){
        String exchangeName = "exchangeName_topic_1";
        String queueName = "queue_topic";
        //这个是发送消息时，消息的关键字
        String[] routing_keys = new String[] { "kernal.info", "cron.warning",
                "auth.info", "kernel.critical" , "shanyao.critical" };
        try{

            //==============================消费者通过不同的通配符与queue绑定==============================================//
            //下面两个消费者是用不同的queue但是他们都受到消息，
            //由此可见：生产者消息是发送给所有的queue的
            /*ConsumerWithKey consumer_1 = new ConsumerWithKey(queueName, exchangeName, "kernal.*");
            Thread thread_1 = new Thread(consumer_1);
            thread_1.start();
            ConsumerWithKey consumer_2 = new ConsumerWithKey(queueName + "_to", exchangeName, "shanyao.*");
            Thread thread_2 = new Thread(consumer_2);
            thread_2.start();*/
            //============================================================================//
            TopicProducer producer = new TopicProducer(exchangeName);
            for (String routing_Key : routing_keys){
                String mesage1 = "shanyao==" + routing_Key;
                producer.sendMessage(mesage1, routing_Key);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
