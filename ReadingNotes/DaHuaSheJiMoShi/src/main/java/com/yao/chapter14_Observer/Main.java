package com.yao.chapter14_Observer;

/**
 * Created by shanyao on 2018/5/24.
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("X",subject));
        subject.attach(new ConcreteObserver("Y",subject));
        subject.attach(new ConcreteObserver("Z",subject));
        subject.setSubjectState("ABC");
        subject.notifyMy();
    }
}
