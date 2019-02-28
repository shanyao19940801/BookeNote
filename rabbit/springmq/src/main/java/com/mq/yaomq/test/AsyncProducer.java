package com.mq.yaomq.test;

import com.mq.yaomq.common.domain.AsyncEventType;
import com.mq.yaomq.common.event.Event;
import com.mq.yaomq.common.rabbit.AsyncEventMsgConvert;
import com.mq.yaomq.common.rabbit.AsyncEventNotifyRabbitMsgBody;
import com.mq.yaomq.common.rabbit.bean.RabbitMsgEntityRouteWarpper;
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
        template.convertAndSend("yao.rabbitmq.exchange", "shan_mq_v1.amqp", "hello object message send!");
        template.convertAndSend("yao_rabbitmq_queue", "foo");
        template.convertAndSend("shan_rabbitmq_queue", "bar");
        template.convertAndSend("yao_async_event_v1.amqp", "tui");

        /*Event event = new Event(AsyncEventType.unknown,"1");
        RabbitMsgEntityRouteWarpper warp = new RabbitMsgEntityRouteWarpper();
        AsyncEventNotifyRabbitMsgBody body = new AsyncEventNotifyRabbitMsgBody();
        warp.setMsgBody(body);
        body.setEvent_type(event.getEventType().getValue());
        body.setEvent_id(event.getId());
        body.setRef_id(event.getRefId());
        warp.setRouteKey("yao_async_event_v1.amqp");
        warp.getEntity();
        template.convertAndSend();*/

        RabbitTemplate rabbitTemplate = new RabbitTemplate(FactoryUtil.getConnectionFactory());
        rabbitTemplate.setExchange("yao.event.rabbitmq.exchange");
        rabbitTemplate.setMessageConverter( new AsyncEventMsgConvert());

    }
}
