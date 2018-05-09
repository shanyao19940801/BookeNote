package com.yao.chapter13_Builder;

/**
 * Created by shanyao on 2018/5/9.
 */
public class ConcreteBuilder1 extends Builder{
    Product product = new Product();
    public void partA() {
        product.addPartt("A");
    }

    public void partB() {
        product.addPartt("B");
    }

    public Product getResult() {
        return product;
    }
}
