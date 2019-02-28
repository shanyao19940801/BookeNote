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
}
