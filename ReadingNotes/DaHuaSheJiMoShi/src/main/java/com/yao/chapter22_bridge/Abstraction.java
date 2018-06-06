package com.yao.chapter22_bridge;

/**
 * Created by shanyao on 2018/6/6.
 */
public class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}
