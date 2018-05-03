package com.yao.chapter08_FactoryMethod;

/**
 * Created by shanyao on 2018/5/3.
 */
public class Main {
    public static void main(String[] args) {
        IFactory factory = new FactoryA();
        factory.create().produce();
        IFactory factoryb = new FactoryB();
        factoryb.create().produce();
    }
}
