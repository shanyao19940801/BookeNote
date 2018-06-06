package com.yao.chapter22_bridge;

/**
 * Created by shanyao on 2018/6/6.
 */
public class RefinedAbstraction extends Abstraction{
    public void operation() {
        implementor.operation();
    }
}
