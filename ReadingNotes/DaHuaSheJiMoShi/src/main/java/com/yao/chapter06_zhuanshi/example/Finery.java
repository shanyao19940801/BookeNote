package com.yao.chapter06_zhuanshi.example;

/**
 * Created by shanyao on 2018/5/1.
 */
public class Finery extends Person {
    protected Person component;

    public void decorate(Person component) {
        this.component = component;
    }

    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
