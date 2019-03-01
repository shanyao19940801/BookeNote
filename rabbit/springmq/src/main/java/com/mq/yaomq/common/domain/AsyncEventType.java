package com.mq.yaomq.common.domain;

/**
 * @create by  单耀
 * @create date  2019/2/28
 */
public enum AsyncEventType {
    unknown(-1),
    ;

    private Integer value;

    AsyncEventType(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static AsyncEventType valueOf(Integer value) {
        AsyncEventType[] eventTypes = values();
        for (AsyncEventType type : eventTypes) {
            if (type.value.equals(value))
                return type;
        }
        return AsyncEventType.unknown;
    }
}
