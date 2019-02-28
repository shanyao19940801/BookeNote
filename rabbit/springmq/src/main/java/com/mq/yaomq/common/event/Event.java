package com.mq.yaomq.common.event;

import com.mq.yaomq.common.domain.AsyncEventType;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class Event {
    private Long eventId;
    private AsyncEventType asyncEventType;
    private String refId;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public AsyncEventType getAsyncEventType() {
        return asyncEventType;
    }

    public void setAsyncEventType(AsyncEventType asyncEventType) {
        this.asyncEventType = asyncEventType;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

}
