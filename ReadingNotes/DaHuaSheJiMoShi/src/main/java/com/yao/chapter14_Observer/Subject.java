package com.yao.chapter14_Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanyao on 2018/5/15.
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    //增加观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }
    //移除观察者
    public void detch(Observer observer) {
        observers.remove(observer);
    }
    //通知
    public void notifyMy() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
