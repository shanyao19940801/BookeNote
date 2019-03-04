package com.rabbit.topic;

import com.rabbit.util.ConnectionFactoryUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.rabbit.topic.Topic.EXCHANGE_NAME;

/**
 * @create by  单耀
 * @create date  2019/3/4
 */
public class TopicConsumer {
    public static void main(String[] args) {
        try {
            ConnectionFactory factory = ConnectionFactoryUtil.getConnectionFactory();
            Connection connection = factory.newConnection();
            final Channel consumerChannel1 = connection.createChannel();
            consumerChannel1.queueDeclare("SystemA", false, false, false, null);
            consumerChannel1.queueBind("SystemA", EXCHANGE_NAME, "#.SystemA");
            consumerChannel1.basicQos(3);

            Consumer consumer1 = new DefaultConsumer(consumerChannel1) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.printf(" [    %2$s<===](%1$s) %3$s\n", "A", "SystemA", message);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                    }
//                    consumerChannel1.basicAck(envelope.getDeliveryTag(), false);
                }
            };
            consumerChannel1.basicConsume("SystemA", true, consumer1);

            /*final Channel consumerChannel2 = connection.createChannel();
            consumerChannel2.queueDeclare("SystemB", false, false, true, null);
            consumerChannel2.queueBind("SystemB", EXCHANGE_NAME, "*.*.SystemB");
            consumerChannel2.basicQos(3);

            Consumer consumer2 = new DefaultConsumer(consumerChannel2) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.printf(" [    %2$s<===](%1$s) %3$s\n", "B -- won't receive first 4 messages", "SystemB", message);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                    }
                    consumerChannel2.basicAck(envelope.getDeliveryTag(), false);
                }
            };

            consumerChannel2.basicConsume("SystemB", false, consumer2);*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
