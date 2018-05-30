package com.yao.chapter16_State;

/**
 * Created by shanyao on 2018/5/30.
 */
public class ConcreteStateA extends State {

    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}
