package com.yao.chapter07_daili;

/**
 * Created by shanyao on 2018/5/2.
 */
public class Proxy extends Subject {
    private RealSubject realSubject;
    public void doSomething() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.doSomething();
    }
}
