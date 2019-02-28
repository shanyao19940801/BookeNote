package com.mq.yaomq.common.rabbit;

import com.mq.yaomq.common.rabbit.bean.RabbitMessageHeader;
import com.mq.yaomq.common.rabbit.bean.RabbitMsgHeaderBase;

import java.util.UUID;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class AsyncEventMsgConvert {

    public static final String API_ASYNC_EVENT_PREFIX = "api_async_event_v";

    protected RabbitMessageHeader formMsgHeader(String version) {
        RabbitMsgHeaderBase header = new RabbitMsgHeaderBase();
        header.setCreate_time(System.currentTimeMillis());
        header.setMessage_id(UUID.randomUUID().toString());
        header.setType(API_ASYNC_EVENT_PREFIX + version);
        return header;
    }
}
