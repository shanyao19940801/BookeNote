package com.mq.yaomq.common.event.impl;

import com.mq.yaomq.common.domain.AsyncEventType;
import com.mq.yaomq.common.event.AsyncEventHandler;
import com.mq.yaomq.common.event.Event;
import com.mq.yaomq.common.rabbit.bean.AsyncEventNotifyRabbitMsgEntity;
import com.mq.yaomq.common.rabbit.bean.AsyncEventNotifyRabbitMsgEntity.AsyncEventNotifyRabbitMsgBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @create by  单耀
 * @create date  2019/3/1
 */
public class AsyncEventHandlerManager {
    private static Logger logger = LoggerFactory.getLogger(AsyncEventHandlerManager.class);
    private Map<AsyncEventType, AsyncEventHandler> handlerMap = new HashMap<>();
    private static Integer threadCount = 1;
    ExecutorService threadPoolExecutor;

    public void init() {
        logger.info("AsyncEventHandlerManager init()");
        threadPoolExecutor = Executors.newFixedThreadPool(threadCount);
    }

    public void handleEvent(AsyncEventNotifyRabbitMsgBody body) {
        AsyncEventType eventType = null;
        eventType = AsyncEventType.valueOf(body.getEvent_type());
        AsyncEventHandler handler = handlerMap.get(eventType);
        if (handler == null) {
            logger.warn("no handle. EventType:" + eventType);
            return;
        }
        Event event = new Event(eventType, body.getRef_id());
        Runnable runnable = getRunnable(event, handler);
        threadPoolExecutor.submit(runnable);
    }

    private Runnable getRunnable(Event event, AsyncEventHandler handler) {
        return new Runnable(){
            @Override
            public void run() {
                boolean result = handler.handleAsyncEvent(event);

                logger.debug("Event eventType:{} refId:{} eventId:{} handled succ:{}", event.getEventType(), event.getRefId(), event.getId(), result);
            }
        };
    }

    public void registerHander(Set<AsyncEventType> eventTypes, AsyncEventHandler handler) {
        logger.info("eventType" + eventTypes + handler);
        for (AsyncEventType eventType : eventTypes) {
            handlerMap.put(eventType, handler);
        }
    }

    public static Integer getThreadCount() {
        return threadCount;
    }

    public static void setThreadCount(Integer threadCount) {
        AsyncEventHandlerManager.threadCount = threadCount;
    }
}
