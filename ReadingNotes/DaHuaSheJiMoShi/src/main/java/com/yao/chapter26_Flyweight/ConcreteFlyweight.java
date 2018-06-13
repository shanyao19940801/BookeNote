package com.yao.chapter26_Flyweight;

/**
 * Created by shanyao on 2018/6/13.
 * ConcreteFlyweight是继承Flyweight超类或实现Flyweight接口，并未内部状态增加存储空间
 */
public class ConcreteFlyweight extends Flyweight{
    public void Operation(int extrinsicstate) {
        System.out.println("具体Flyweight："+extrinsicstate);
    }
}
