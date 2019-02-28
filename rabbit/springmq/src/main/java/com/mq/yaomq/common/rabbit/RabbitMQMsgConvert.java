package com.mq.yaomq.common.rabbit;

import com.alibaba.fastjson.JSON;
import com.mq.yaomq.common.rabbit.bean.RabbitMessageBody;
import com.mq.yaomq.common.rabbit.bean.RabbitMessageEntity;
import com.mq.yaomq.common.rabbit.bean.RabbitMessageHeader;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public abstract class RabbitMQMsgConvert implements MessageConverter {
    protected static final String CHATSET = "UTF-8";

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        RabbitMessageBody body = (RabbitMessageBody)object;
        RabbitMessageHeader header = formMsgHeader(body.getVersion());
        RabbitMessageEntity entity = new RabbitMessageEntity(header, body);
        byte[] bytes = null;
        try {
            bytes = JSON.toJSONString(entity).getBytes(CHATSET);
        } catch (UnsupportedEncodingException e) {
            throw new MessageConversionException("failed to convert to program msg content", e);
        }
        messageProperties.setMessageId(header.getMessage_id());
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(CHATSET);
        messageProperties.setContentLength(bytes.length);
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        Message message = new Message(bytes, messageProperties);
        return message;
    }


    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        throw new UnsupportedOperationException("not support from operation");
    }

    abstract protected RabbitMessageHeader formMsgHeader(String version);
}
