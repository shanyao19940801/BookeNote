package com.yao.chapter16_State;

/**
 * Created by shanyao on 2018/5/30.
 */
public class Main {
    public static void main(String[] args) {
        //设置初始状态为A
        Context context = new Context(new ConcreteStateA());

        context.request();
        context.request();
        context.request();
        context.request();

    }
}
