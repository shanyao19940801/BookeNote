package com.yao.chapter14_Observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by shanyao on 2018/7/31.
 */
public class ObserHdk {
    public static void main(String[] args) {

        Observable observable = new Observable();
        ConcreObserver o = new ConcreObserver("Shan");
        observable.addObserver(o);
        observable.notifyObservers();

    }
}
