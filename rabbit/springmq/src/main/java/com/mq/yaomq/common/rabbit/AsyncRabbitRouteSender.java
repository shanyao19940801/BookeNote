package com.mq.yaomq.common.rabbit;

import com.alibaba.fastjson.JSON;
import com.mq.yaomq.common.rabbit.bean.RabbitMsgEntityRouteWarpper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.util.StringUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @create by  单耀
 * @create date  2019/2/28
 * @Decription 事件发送
 */
public class AsyncRabbitRouteSender {
    private static final Logger logger = LoggerFactory.getLogger(AsyncRabbitRouteSender.class);
    private final LinkedBlockingQueue<RabbitMsgEntityRouteWarpper> iq = new LinkedBlockingQueue(10000);
    private ExecutorService service;
    private Integer threadCount = 1;
    private AmqpTemplate amqpTemplate;
    private String senderName = "";

    public AsyncRabbitRouteSender() {
    }

    public void start() {
        this.stop();
        this.service = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; ++i) {
            this.service.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        RabbitMsgEntityRouteWarpper warpper = null;
                        try {
                            warpper = AsyncRabbitRouteSender.this.iq.take();
                        } catch (InterruptedException e) {
                            AsyncRabbitRouteSender.logger.info("async message thread stop");
                            return;
                        }
                        if (warpper != null) {
                            AsyncRabbitRouteSender.this.convertAndSenderMessage(warpper);
                        }
                    }
                }
            });
        }
    }

    private void convertAndSenderMessage(RabbitMsgEntityRouteWarpper warpper) {
        if (StringUtils.isEmpty(warpper.getRouteKey())) {
            this.amqpTemplate.convertAndSend(warpper.getEntity());
        } else {
            this.amqpTemplate.convertAndSend(warpper.getRouteKey(), warpper.getEntity());
        }
    }

    public void sendMsg(RabbitMsgEntityRouteWarpper msg) {
        if (!this.iq.offer(msg)) {
            logger.error("program status msg queue is full. sender message sync :{}", JSON.toJSONString(msg));
            this.convertAndSenderMessage(msg);
        } else if (logger.isTraceEnabled()) {
            logger.trace("program status msg pushed into queue suc. msg:{}", JSON.toJSONString(msg));
        }
    }

    public void stop() {
        if (this.service != null) {
            logger.info("try to stop AsyncRabbitSender.");
            this.service.shutdownNow();
            logger.info("stop AsyncRabbitSender suc.");
        }

    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
