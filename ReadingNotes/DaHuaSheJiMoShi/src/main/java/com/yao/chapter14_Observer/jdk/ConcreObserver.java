package com.yao.chapter14_Observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by shanyao on 2018/7/31.
 */
public class ConcreObserver implements Observer {
    private String name;

    public ConcreObserver(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        System.out.println(name + "receive" + arg + " from " + o.toString());
    }
}
