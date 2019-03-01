package com.mq.yaomq.common.rabbit.bean;

/**
 * @create by  单耀
 * @create date  2019/3/1
 */
public class AsyncEventNotifyRabbitMsgEntity {
    private AsyncEventNotifyRabbitMsgEntity.AsyncEventNotifyRabbitMsgBody body;
    private AsyncEventNotifyRabbitMsgEntity.AsyncEventNotifyRabbitMsgHeader header;

    public AsyncEventNotifyRabbitMsgBody getBody() {
        return body;
    }

    public void setBody(AsyncEventNotifyRabbitMsgBody body) {
        this.body = body;
    }

    public AsyncEventNotifyRabbitMsgHeader getHeader() {
        return header;
    }

    public void setHeader(AsyncEventNotifyRabbitMsgHeader header) {
        this.header = header;
    }

    public static class AsyncEventNotifyRabbitMsgBody extends AbstractRabbitMessageBody {
        private Long event_id;
        private String ref_id;
        private Integer event_type;

        public AsyncEventNotifyRabbitMsgBody() {
        }

        public String getVersion() {
            return "1";
        }

        public Long getEvent_id() {
            return this.event_id;
        }

        public void setEvent_id(Long event_id) {
            this.event_id = event_id;
        }

        public String getRef_id() {
            return this.ref_id;
        }

        public void setRef_id(String ref_id) {
            this.ref_id = ref_id;
        }

        public Integer getEvent_type() {
            return this.event_type;
        }

        public void setEvent_type(Integer event_type) {
            this.event_type = event_type;
        }

        public String getRouteKey(String asyncEventPrefix) {
            return asyncEventPrefix + this.getVersion() + "." + this.event_type;
        }
    }

    public static class AsyncEventNotifyRabbitMsgHeader extends RabbitMsgHeaderBase {
        public AsyncEventNotifyRabbitMsgHeader() {
        }
    }
}
