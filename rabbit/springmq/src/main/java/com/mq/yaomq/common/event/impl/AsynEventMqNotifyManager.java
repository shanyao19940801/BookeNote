package com.mq.yaomq.common.event.impl;

import com.alibaba.fastjson.JSON;
import com.mq.yaomq.common.event.Event;
import com.mq.yaomq.common.rabbit.AsyncEventNotifyRabbitMsgBody;
import com.mq.yaomq.common.rabbit.AsyncRabbitRouteSender;
import com.mq.yaomq.common.rabbit.bean.RabbitMsgEntityRouteWarpper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class AsynEventMqNotifyManager {
    private static Logger logger = LoggerFactory.getLogger(AsynEventMqNotifyManager.class);
    public String aysncEventPrefix;
    private AsyncRabbitRouteSender asyncEventMsgAsyncSender;
    public AsynEventMqNotifyManager(String aysncEventPrefix) {
        this.aysncEventPrefix = aysncEventPrefix;
    }

    public void fireEvent(Event event) {
        try {
            RabbitMsgEntityRouteWarpper warp = new RabbitMsgEntityRouteWarpper();
            AsyncEventNotifyRabbitMsgBody body = new AsyncEventNotifyRabbitMsgBody();
            warp.setMsgBody(body);
            body.setEvent_type(event.getEventType().getValue());
            body.setEvent_id(event.getId());
            body.setRef_id(event.getRefId());
            warp.setRouteKey(body.getRouteKey(this.aysncEventPrefix));
            this.asyncEventMsgAsyncSender.sendMsg(warp);
        } catch (Exception var4) {
            logger.warn("failed send msg:{}", JSON.toJSONString(event), var4);
        }
    }

    public AsyncRabbitRouteSender getAsyncEventMsgAsyncSender() {
        return asyncEventMsgAsyncSender;
    }

    public void setAsyncEventMsgAsyncSender(AsyncRabbitRouteSender asyncEventMsgAsyncSender) {
        this.asyncEventMsgAsyncSender = asyncEventMsgAsyncSender;
    }

    public String getAysncEventPrefix() {
        return aysncEventPrefix;
    }

    public void setAysncEventPrefix(String aysncEventPrefix) {
        this.aysncEventPrefix = aysncEventPrefix;
    }
}
