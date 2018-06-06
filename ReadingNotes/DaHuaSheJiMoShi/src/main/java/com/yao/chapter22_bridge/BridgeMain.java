package com.yao.chapter22_bridge;

/**
 * Created by shanyao on 2018/6/6.
 */
public class BridgeMain {

    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction();
        abstraction.setImplementor(new ConcreteImplementorA());
        abstraction.operation();

        abstraction.setImplementor(new ConcreteImplementorB());
        abstraction.operation();
    }
}
