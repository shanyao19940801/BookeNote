package com.mq.yaomq.business.manager;

import com.mq.yaomq.common.domain.AsyncEventType;
import com.mq.yaomq.common.event.AsyncEventHandler;
import com.mq.yaomq.common.event.Event;
import com.mq.yaomq.common.event.impl.AsynEventMqNotifyManager;
import com.mq.yaomq.common.event.impl.AsyncEventHandlerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @create by  单耀
 * @create date  2019/3/1
 */
@Component
public class YaoManager {
    @Autowired
    AsyncEventHandlerManager asyncEventHandlerManager;
    @PostConstruct
    public void printEvent() {
        Set<AsyncEventType> set = new HashSet<>(Arrays.asList(AsyncEventType.shan, AsyncEventType.yao));
        AsyncEventHandler handler = new AsyncEventHandler() {
            @Override
            public boolean handleAsyncEvent(Event event) {
                switch (event.getEventType()) {
                    case unknown:
                        System.out.println("unknown");
                        break;
                    case yao:
                        System.out.println("yao");
                        break;
                    case shan:
                        System.out.println("shan");
                        break;
                }
                return true;
            }
        };
        asyncEventHandlerManager.registerHander(set, handler);
    }
}
