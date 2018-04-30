package com.yao.chapter06_zhuanshi;

/**
 * Created by shanyao on 2018/4/30.
 */
public class Main {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDectoratorA d1 = new ConcreteDectoratorA();
        ConcreteDectoratorB d2 = new ConcreteDectoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();
    }
}
