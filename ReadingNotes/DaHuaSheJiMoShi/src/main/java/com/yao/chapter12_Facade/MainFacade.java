package com.yao.chapter12_Facade;

/**
 * Created by shanyao on 2018/5/7.
 */
public class MainFacade {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
