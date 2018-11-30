package com.rabbit.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListener implements MessageListener {
    public void onMessage(Message message) {
        
    }
}
