package com.mq.yaomq.common.rabbit.bean;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class RabbitMsgHeaderBase implements RabbitMessageHeader{
    private Long create_time;
    private String message_id;
    private String type;


    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
