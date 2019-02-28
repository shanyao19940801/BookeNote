package com.mq.yaomq.common.rabbit.bean;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public interface RabbitMessageHeader {
    Long getCreate_time();

    void setCreate_time(Long var1);

    String getMessage_id();

    void setMessage_id(String var1);

    String getType();

    void setType(String var1);
}
