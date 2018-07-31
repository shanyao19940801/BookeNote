package com.yao.chapter14_Observer.jdk;

import java.util.Observable;

/**
 * Created by shanyao on 2018/7/31.
 */
public class Publisher extends Observable {
    private String name;
    public Publisher(String name) {
        this.name = name;
    }
}
