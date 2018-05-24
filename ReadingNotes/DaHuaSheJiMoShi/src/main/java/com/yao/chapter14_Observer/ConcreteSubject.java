package com.yao.chapter14_Observer;

/**
 * Created by shanyao on 2018/5/24.
 */
public class ConcreteSubject extends Subject {
    private String subjectState;
    //具体被观察者状态


    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
