package com.mq.yaomq.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mq.yaomq.common.event.impl.AsyncEventHandlerManager;
import com.mq.yaomq.common.rabbit.bean.AsyncEventNotifyRabbitMsgEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @create by  单耀
 * @create date  2019/2/27
 */
@Component
public class EventListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);
    private static final String DEFAULT_CHARSET = "UTF-8";
    @Autowired
    AsyncEventHandlerManager asyncEventHandlerManager;
    @Override
    public void onMessage(Message message) {
        MessageProperties messageProperties = message.getMessageProperties();
        String encoding = messageProperties.getContentEncoding();
        if (encoding == null) {
            encoding = DEFAULT_CHARSET;
        }

        String content = "";
        try {
            content = new String(message.getBody(), encoding);
        } catch (Exception e) {
            logger.error("failed to decode mq message:{}", encoding, e);
            return;
        }

        try {
            logger.debug("received {}", JSON.toJSONString(content));
            AsyncEventNotifyRabbitMsgEntity rabbitMessageEntity = JSONObject.parseObject(content, AsyncEventNotifyRabbitMsgEntity.class);
            asyncEventHandlerManager.handleEvent(rabbitMessageEntity.getBody());
        } catch (Exception e){
            logger.error("failed to handle mq message:{}, content:{} ", encoding, content, e);
        }
        System.out.println("Shan============:"+message);
    }
}
