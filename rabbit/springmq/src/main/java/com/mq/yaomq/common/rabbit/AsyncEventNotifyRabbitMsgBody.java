package com.mq.yaomq.common.rabbit;

import com.mq.yaomq.common.rabbit.bean.RabbitMessageBody;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public class AsyncEventNotifyRabbitMsgBody implements RabbitMessageBody {
    private Long event_id;
    private String ref_id;
    private Integer event_type;

    @Override
    public String getVersion() {
        return "1";
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public Integer getEvent_type() {
        return event_type;
    }

    public void setEvent_type(Integer event_type) {
        this.event_type = event_type;
    }

    public String getRouteKey(String prefix) {
        return prefix + this.getVersion() + "." + this.event_type;
    }
}
