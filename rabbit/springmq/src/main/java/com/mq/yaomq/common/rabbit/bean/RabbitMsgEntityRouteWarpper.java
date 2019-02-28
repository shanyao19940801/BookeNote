package com.mq.yaomq.common.rabbit.bean;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class RabbitMsgEntityRouteWarpper {
    private static final String EMPTY_ROUTE_KEY = "";
    private String routeKey;
    private RabbitMessageBody msgBody;

    public RabbitMsgEntityRouteWarpper() {
    }

    public RabbitMsgEntityRouteWarpper(RabbitMessageBody msgBody) {
        this("", msgBody);
    }

    public RabbitMsgEntityRouteWarpper(String routeKey, RabbitMessageBody msgBody) {
        this.routeKey = routeKey;
        this.msgBody = msgBody;
    }

    public String getRouteKey() {
        return this.routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    public RabbitMessageBody getEntity() {
        return this.msgBody;
    }

    public void setMsgBody(RabbitMessageBody entity) {
        this.msgBody = entity;
    }
}
