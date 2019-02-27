package com.mq.yaomq.test;

import com.mq.yaomq.factory.FactoryUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @create by  单耀
 * @create date  2019/2/27
 */
public class AsyncProducer {
    public static void main(String[] args) {
        AmqpTemplate template = new RabbitTemplate(FactoryUtil.getConnectionFactory());
        template.convertAndSend("yao.rabbitmq.exchange", "yao_mq_v1.amqp", "hello object message send!");
        /*template.convertAndSend("yao_rabbitmq_queue", "foo");
        template.convertAndSend("yao_rabbitmq_queue", "bar");
        template.convertAndSend("yao_rabbitmq_queue", "tui");*/
    }
}
