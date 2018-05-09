package com.yao.chapter13_Builder;

/**
 * Created by shanyao on 2018/5/9.
 */
public class ConcreteBuilder2 extends Builder {
    Product product = new Product();
    public void partA() {
        product.addPartt("X");
    }

    public void partB() {
        product.addPartt("Y");
    }

    public Product getResult() {
        return product;
    }
}
