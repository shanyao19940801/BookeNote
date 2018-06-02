package com.yao.chapter18_Memento;

/**
 * Created by shanyao on 2018/6/2.
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
