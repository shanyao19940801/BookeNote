package com.mq.yaomq.params;

/**
 * @create by  单耀
 * @create date  2019/2/26
 */
public class MqListenParam {
    private String queueName;
    private String routingKey;
    private String exchangeName;

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

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }
}
