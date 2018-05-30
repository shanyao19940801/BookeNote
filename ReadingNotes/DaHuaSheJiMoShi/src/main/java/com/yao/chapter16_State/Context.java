package com.yao.chapter16_State;

/**
 * Created by shanyao on 2018/5/30.
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态：" + state.toString());
    }

    public void request() {
        state.handle(this);
    }
}
