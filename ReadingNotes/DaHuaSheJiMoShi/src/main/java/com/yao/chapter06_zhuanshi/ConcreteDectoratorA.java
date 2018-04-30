package com.yao.chapter06_zhuanshi;

/**
 * Created by shanyao on 2018/4/30.
 */
public class ConcreteDectoratorA extends Decorator{
    private String addedState;

    public void operation() {
        super.operation();
        addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }
}
