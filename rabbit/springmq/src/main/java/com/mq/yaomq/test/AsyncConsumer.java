package com.mq.yaomq.test;

import com.mq.yaomq.factory.FactoryUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @create by  单耀
 * @create date  2019/2/27
 */
public class AsyncConsumer {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("amqp://shanyao:123456@47.100.211.121:5672");
        ConnectionFactory connectionFactory = new CachingConnectionFactory(uri);
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setQueueNames("queue");
        container.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                System.out.println("received: " + message);
            }
        });
        container.start();

        AmqpTemplate template = new RabbitTemplate(connectionFactory);
        template.convertAndSend("queue", "foo");
        template.convertAndSend("queue", "bar");
        template.convertAndSend("queue", "tui");
    }
}
