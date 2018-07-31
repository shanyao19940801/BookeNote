package com.yao.chapter14_Observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by shanyao on 2018/7/31.
 */
public class Main {
    public static void main(String[] args) {

        Publisher publisher = new Publisher("yao");
        publisher.addObserver(new ConcreObserver("shan"));

        publisher.notifyObservers("sdf");

    }
}
