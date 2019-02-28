package com.mq.yaomq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @create by  单耀
 * @create date  2019/2/27
 */
@Component
public class ShanListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("Shan============:"+message);
    }
}
