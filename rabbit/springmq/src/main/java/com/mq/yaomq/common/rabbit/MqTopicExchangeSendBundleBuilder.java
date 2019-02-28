package com.mq.yaomq.common.rabbit;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class MqTopicExchangeSendBundleBuilder {
    private String exchange;
    private MessageConverter asyncEventMsgConvert;
    private ConnectionFactory connectionFactory;

    public MqTopicExchangeSendBundleBuilder(String exchange, MessageConverter asyncEventMsgConvert, ConnectionFactory connectionFactory) {
        this.exchange = exchange;
        this.asyncEventMsgConvert = asyncEventMsgConvert;
        this.connectionFactory = connectionFactory;
    }

    public MqTopicExchangeSendBundle buildBundle() {
        MqTopicExchangeSendBundle bundle = new MqTopicExchangeSendBundle();
        bundle.setConnectionFactory(this.connectionFactory);
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        TopicExchange topicExchange = new TopicExchange(this.exchange, true, false);
        rabbitAdmin.declareExchange(topicExchange);
        bundle.setRabbitAdmin(rabbitAdmin);
        bundle.setTopicExchange(topicExchange);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(exchange);
        rabbitTemplate.setMessageConverter(asyncEventMsgConvert);
        bundle.setRabbitTemplate(rabbitTemplate);
        return bundle;
    }

    public class MqTopicExchangeSendBundle {
        private RabbitTemplate rabbitTemplate;
        private RabbitAdmin rabbitAdmin;
        private ConnectionFactory connectionFactory;
        private TopicExchange topicExchange;

        public RabbitTemplate getRabbitTemplate() {
            return rabbitTemplate;
        }

        public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
        }

        public RabbitAdmin getRabbitAdmin() {
            return rabbitAdmin;
        }

        public void setRabbitAdmin(RabbitAdmin rabbitAdmin) {
            this.rabbitAdmin = rabbitAdmin;
        }

        public ConnectionFactory getConnectionFactory() {
            return connectionFactory;
        }

        public void setConnectionFactory(ConnectionFactory connectionFactory) {
            this.connectionFactory = connectionFactory;
        }

        public TopicExchange getTopicExchange() {
            return topicExchange;
        }

        public void setTopicExchange(TopicExchange topicExchange) {
            this.topicExchange = topicExchange;
        }
    }
}
