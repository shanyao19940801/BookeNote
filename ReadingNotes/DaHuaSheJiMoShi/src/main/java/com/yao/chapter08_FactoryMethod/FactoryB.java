package com.yao.chapter08_FactoryMethod;

/**
 * Created by shanyao on 2018/5/3.
 */
public class FactoryB implements IFactory {
    public Product create() {
        return new ProductB();
    }
}
