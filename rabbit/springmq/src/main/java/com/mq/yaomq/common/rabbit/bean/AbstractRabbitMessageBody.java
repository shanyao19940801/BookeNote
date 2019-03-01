package com.mq.yaomq.common.rabbit.bean;

import java.util.UUID;

/**
 * @create by  单耀
 * @create date  2019/3/1
 */
public abstract class AbstractRabbitMessageBody implements RabbitMessageBody{
    private String messageId = UUID.randomUUID().toString();
    private Long timestamp = System.currentTimeMillis();
    private Long expirationSecond;

    public AbstractRabbitMessageBody() {
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getExpirationSecond() {
        return this.expirationSecond;
    }

    public void setExpirationSecond(Long expirationSecond) {
        this.expirationSecond = expirationSecond;
    }
}
