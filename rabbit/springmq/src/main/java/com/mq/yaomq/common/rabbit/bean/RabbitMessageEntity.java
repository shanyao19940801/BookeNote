package com.mq.yaomq.common.rabbit.bean;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class RabbitMessageEntity {
    private RabbitMessageHeader header;
    private RabbitMessageBody body;

    public RabbitMessageEntity() {
    }

    public RabbitMessageEntity(RabbitMessageHeader header, RabbitMessageBody body) {
        this.header = header;
        this.body = body;
    }

    public RabbitMessageHeader getHeader() {
        return this.header;
    }

    public void setHeader(RabbitMessageHeader header) {
        this.header = header;
    }

    public RabbitMessageBody getBody() {
        return this.body;
    }

    public void setBody(RabbitMessageBody body) {
        this.body = body;
    }
}
