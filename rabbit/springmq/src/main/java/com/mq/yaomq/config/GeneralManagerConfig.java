package com.mq.yaomq.config;

import com.mq.yaomq.common.event.impl.AsynEventMqNotifyManager;
import com.mq.yaomq.common.event.impl.AsyncEventHandlerManager;
import com.mq.yaomq.common.rabbit.AsyncRabbitRouteSender;
import com.mq.yaomq.manager.EventManager;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
@Configuration
public class GeneralManagerConfig {
    public final static String NEW_ASYNC_EVENT_MSG_ASYNCSENDER = "newAsyncEventMsgAsyncSender";


    @Bean
    public AsynEventMqNotifyManager asynEventMqNotifyManager(
            @Qualifier(NEW_ASYNC_EVENT_MSG_ASYNCSENDER) AsyncRabbitRouteSender asyncRabbitRouteSender
    ) {
        AsynEventMqNotifyManager asynEventMqNotifyManager = new AsynEventMqNotifyManager();
        asynEventMqNotifyManager.setAsyncEventMsgAsyncSender(asyncRabbitRouteSender);
        asynEventMqNotifyManager.setAysncEventPrefix("yao_async_event_v");
        return asynEventMqNotifyManager;
    }

    @Bean
    public EventManager eventManager(
            AsynEventMqNotifyManager asynEventMqNotifyManager
    ) {
        EventManager eventManager = new EventManager(asynEventMqNotifyManager);
        return eventManager;
    }

    @Bean(initMethod = "init")
    public AsyncEventHandlerManager asyncEventHandlerManager() {
        AsyncEventHandlerManager asyncEventHandlerManager = new AsyncEventHandlerManager();
        asyncEventHandlerManager.setThreadCount(3);
        return asyncEventHandlerManager;
    }
}
