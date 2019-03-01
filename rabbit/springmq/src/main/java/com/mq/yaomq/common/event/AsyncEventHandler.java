package com.mq.yaomq.common.event;

/**
 * @create by  单耀
 * @create date  2019/3/1
 */
public interface AsyncEventHandler {
    boolean handleAsyncEvent(Event event);
}
