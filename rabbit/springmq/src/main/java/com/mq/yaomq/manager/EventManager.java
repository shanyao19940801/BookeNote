package com.mq.yaomq.manager;

import com.mq.yaomq.common.event.Event;
import com.mq.yaomq.common.event.impl.AsynEventMqNotifyManager;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class EventManager {
    private AsynEventMqNotifyManager asynEventMqNotifyManager;

    public EventManager() {
    }

    public void fireEvent(Event event) {
        asynEventMqNotifyManager.fireEvent(event);
    }
    public EventManager(AsynEventMqNotifyManager asynEventMqNotifyManager) {
        this.asynEventMqNotifyManager = asynEventMqNotifyManager;
    }

    public AsynEventMqNotifyManager getAsynEventMqNotifyManager() {
        return asynEventMqNotifyManager;
    }

    public void setAsynEventMqNotifyManager(AsynEventMqNotifyManager asynEventMqNotifyManager) {
        this.asynEventMqNotifyManager = asynEventMqNotifyManager;
    }
}
