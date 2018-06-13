package com.yao.chapter26_Flyweight;

/**
 * Created by shanyao on 2018/6/13.
 * 所有具有享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态
 */
public abstract class Flyweight {
    public abstract void Operation(int extrinsicstate);
}
