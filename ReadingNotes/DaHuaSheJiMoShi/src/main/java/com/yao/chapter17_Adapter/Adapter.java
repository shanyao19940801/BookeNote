package com.yao.chapter17_Adapter;

/**
 * Created by shanyao on 2018/6/1.
 * 适配器
 */
public class Adapter extends Target{
    private Adaptee adaptee = new Adaptee();

    public void request() {
        adaptee.specificRequest();
    }

}
