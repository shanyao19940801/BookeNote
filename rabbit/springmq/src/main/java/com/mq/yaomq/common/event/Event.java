package com.mq.yaomq.common.event;

import com.mq.yaomq.common.domain.AsyncEventType;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class Event {
    private Long id;
    private AsyncEventType eventType;
    private String refId;

    public Event(AsyncEventType eventType, String refId) {
        this.eventType = eventType;
        this.refId = refId;
    }

    public Event(Long id, AsyncEventType eventType, String refId) {
        this.id = id;
        this.eventType = eventType;
        this.refId = refId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AsyncEventType getEventType() {
        return eventType;
    }

    public void setEventType(AsyncEventType eventType) {
        this.eventType = eventType;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

}
