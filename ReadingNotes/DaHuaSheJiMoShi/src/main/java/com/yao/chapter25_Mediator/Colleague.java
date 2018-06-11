package com.yao.chapter25_Mediator;

/**
 * Created by shanyao on 2018/6/11
 * 抽象同事类.
 */
public class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
