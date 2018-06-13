package com.yao.chapter26_Flyweight;

/**
 * Created by shanyao on 2018/6/13.
 * UnsharedConcreteFlyweight是指那些不需要共享的Flyweight子类。因为Flyweight接口共享成为可能，但它并不强制共享
 */
public class UnsharedConcreteFlyweight extends Flyweight{
    public void Operation(int extrinsicstate) {
        System.out.println("不共享的具体Flyweight：" + extrinsicstate);
    }
}
