package com.yao.chapter13_Builder;

/**
 * Created by shanyao on 2018/5/9.
 */
public class BuilderMain {
    public static void main(String[] args) {
        Director director = new Director();
        Builder concreteBuilder1 = new ConcreteBuilder1();
        director.concrete(concreteBuilder1);
        concreteBuilder1.getResult().show();

        Builder builder = new ConcreteBuilder2();
        director.concrete(builder);
        builder.getResult().show();
    }
}
