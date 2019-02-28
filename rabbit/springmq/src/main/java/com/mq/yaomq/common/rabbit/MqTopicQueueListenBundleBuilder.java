package com.mq.yaomq.common.rabbit;

import com.mq.yaomq.params.MqListenParam;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class MqTopicQueueListenBundleBuilder {

    private MqListenParam mqListenParam;
    private MessageListener messageListener;
    private ConnectionFactory connectionFactory;
    private int listenConcurrentConsumers = 1;

    public MqTopicQueueListenBundleBuilder(MqListenParam mqListenParam, MessageListener messageListener, ConnectionFactory connectionFactory) {
        this.mqListenParam = mqListenParam;
        this.messageListener = messageListener;
        this.connectionFactory = connectionFactory;
    }

    public MqTopicQueueListenBundleBuilder.MqTopicQueueListenBundle initBundle() {
        MqTopicQueueListenBundleBuilder.MqTopicQueueListenBundle bondle = new MqTopicQueueListenBundle();
        bondle.setConnectionFactory(this.connectionFactory);

        TopicExchange topicExchange = new TopicExchange(mqListenParam.getExchangeName(), true, false);
        Queue queue = new Queue(mqListenParam.getQueueName());
        Binding binding = BindingBuilder.bind(queue).to(topicExchange).with(mqListenParam.getRoutingKey());

        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareExchange(topicExchange);
        rabbitAdmin.declareBinding(binding);
        bondle.setRabbitAdmin(rabbitAdmin);

        bondle.setBinding(binding);

        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(this.connectionFactory);
        listenerContainer.setConcurrentConsumers(this.listenConcurrentConsumers);
        listenerContainer.setChannelTransacted(true);
        listenerContainer.setQueues(new Queue[]{queue});
        listenerContainer.setMessageListener(messageListener);
        bondle.setListenerContainer(listenerContainer);
        bondle.setTopicExchange(topicExchange);
        bondle.setQueue(queue);
        return bondle;
    }

    public static class MqTopicQueueListenBundle {
        private AbstractMessageListenerContainer listenerContainer;
        private RabbitAdmin rabbitAdmin;
        private ConnectionFactory connectionFactory;
        private TopicExchange topicExchange;
        private Queue queue;
        private Binding binding;

        public AbstractMessageListenerContainer getListenerContainer() {
            return listenerContainer;
        }

        public void setListenerContainer(AbstractMessageListenerContainer listenerContainer) {
            this.listenerContainer = listenerContainer;
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

        public Queue getQueue() {
            return queue;
        }

        public void setQueue(Queue queue) {
            this.queue = queue;
        }

        public Binding getBinding() {
            return binding;
        }

        public void setBinding(Binding binding) {
            this.binding = binding;
        }
    }
}
