package com.yao.chapter14_Observer;

/**
 * Created by shanyao on 2018/5/24.
 */
public class ConcreteObserver extends Observer {
    private String name;
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者"+name+"的新状态是"+observerState);
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}
