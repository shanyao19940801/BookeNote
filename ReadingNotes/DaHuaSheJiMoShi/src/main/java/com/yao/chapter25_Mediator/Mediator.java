package com.yao.chapter25_Mediator;

/**
 * Created by shanyao on 2018/6/11.
 * 抽象中介者类
 */
public abstract class Mediator {
    //抽象发送消息方法，得到同事对象和发送消息
    public abstract void send(String message, Colleague colleague);
}
