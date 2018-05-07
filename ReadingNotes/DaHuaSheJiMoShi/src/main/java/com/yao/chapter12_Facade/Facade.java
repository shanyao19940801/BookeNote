package com.yao.chapter12_Facade;

/**
 * Created by shanyao on 2018/5/7.
 */
public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    public void methodA() {
        System.out.println("方法组A");
        one.methodOne();
        two.methodTwo();
        three.methodThree();
    }

    public void methodB() {
        System.out.println("方法组B");
        three.methodThree();
        one.methodOne();
    }
}
