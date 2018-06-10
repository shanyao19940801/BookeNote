package com.yao.chapter24_ChainOfResponsibility;

/**
 * Created by shanyao on 2018/6/10.
 * 定义一个处理请示的接口
 */
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    public abstract void HandleRequest(int request);
}
