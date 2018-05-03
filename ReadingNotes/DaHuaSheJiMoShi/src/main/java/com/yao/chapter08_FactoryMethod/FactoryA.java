package com.yao.chapter08_FactoryMethod;

/**
 * Created by shanyao on 2018/5/3.
 */
public class FactoryA implements IFactory {
    public Product create() {
        return new ProductA();
    }
}
