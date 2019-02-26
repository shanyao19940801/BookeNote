package com.mq.yaomq.params;

/**
 * @create by  单耀
 * @create date  2019/2/26
 */
public class MqListenParam {
    private String queueName;
    private String routingKey;
    private String topicExchange;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getTopicExchange() {
        return topicExchange;
    }

    public void setTopicExchange(String topicExchange) {
        this.topicExchange = topicExchange;
    }
}
