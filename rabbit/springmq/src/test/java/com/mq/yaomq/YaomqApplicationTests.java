package com.mq.yaomq;

import com.alibaba.fastjson.JSONObject;
import com.mq.yaomq.common.domain.AsyncEventType;
import com.mq.yaomq.common.event.Event;
import com.mq.yaomq.common.rabbit.bean.AsyncEventNotifyRabbitMsgEntity;
import com.mq.yaomq.manager.EventManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YaomqApplicationTests {
    @Autowired
    EventManager eventManager;
    @Test
    public void contextLoads() {
    }

//    @Autowired
//    private RabbitAdmin rabbitAdmin;

    @Test
    public void testAdmin() throws Exception {
        Event event = new Event(AsyncEventType.unknown, "111");
        eventManager.fireEvent(event);
    }

    @Test
    public void testJson() {
        String json = "{\"body\":{\"event_type\":-1,\"messageId\":\"bc771fa4-13dc-4813-80ed-022af365122d\",\"ref_id\":\"111\",\"timestamp\":1551420506688,\"version\":\"1\"},\"header\":{\"create_time\":1551420506690,\"message_id\":\"64e0de0a-6246-4ea2-81d5-dfc1dac163a4\",\"type\":\"api_async_event_v1\"}}";
        AsyncEventNotifyRabbitMsgEntity rabbitMessageEntity = JSONObject.parseObject(json, AsyncEventNotifyRabbitMsgEntity.class);
    }

}
