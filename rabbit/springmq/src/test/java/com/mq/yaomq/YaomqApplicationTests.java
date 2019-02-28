package com.mq.yaomq;

import com.mq.yaomq.common.domain.AsyncEventType;
import com.mq.yaomq.common.event.Event;
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

}
