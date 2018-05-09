package com.yao.chapter13_Builder;

/**
 * Created by shanyao on 2018/5/9.
 */
public class Director {
    public Director() {
    }

    public void concrete(Builder builder) {
        builder.partA();
        builder.partB();
    }
}
