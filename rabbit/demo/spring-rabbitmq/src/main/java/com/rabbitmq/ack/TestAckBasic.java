package com.rabbitmq.ack;

import com.rabbitmq.client.*;
import com.rabbitmq.util.FactoryUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.rabbitmq.util.Constants.EXCHANGE_ACK;

public class TestAckBasic {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = FactoryUtil.getConnectionFactory();
        Connection connection = factory.newConnection();
        final Channel consumerChannel1 = connection.createChannel();
        consumerChannel1.queueDeclare(QUEUE_NAME, false, false, false, null);
        consumerChannel1.basicQos(3);
        Consumer consumer1 = new DefaultConsumer(consumerChannel1) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.printf("in consumer A (delivery tag is %d): %s\n", envelope.getDeliveryTag(), message);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                }
                consumerChannel1.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        /*
            basicConsume
            方法：启动一个消费者。
            queue：队列名
            autoAck:true表示服务器等消息一次性交付过来，false表示服务器期望等到消息
            consumerTag：客户端生成的用户标签来建立上下文
            noLocal:如果服务器不应传递到此通道连接上发布的消费者消息
            exclusive:这是否是一个专有的消费
            argumnets:队列其他参数设置
            callback:与消费者对接的接口
         */
        consumerChannel1.basicConsume(QUEUE_NAME, false, consumer1);

        final Channel consumerChannel2 = connection.createChannel();
        consumerChannel2.basicQos(3);
        Consumer consumer2 = new DefaultConsumer(consumerChannel2) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.printf("in consumer B (delivery tag is %d): %s\n", envelope.getDeliveryTag(), message);
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                }
                consumerChannel2.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        consumerChannel2.basicConsume(QUEUE_NAME, false, consumer2);

        Channel senderChannel = connection.createChannel();
        for (int i = 0; i < 10;) {
            String message = "NO. " + ++i;
            TimeUnit.MILLISECONDS.sleep(100);
            senderChannel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        }
        senderChannel.close();
    }
}
