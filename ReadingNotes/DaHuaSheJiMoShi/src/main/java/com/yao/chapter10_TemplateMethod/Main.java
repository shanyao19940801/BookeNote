package com.yao.chapter10_TemplateMethod;

/**
 * Created by shanyao on 2018/5/5.
 */
public class Main {
    public static void main(String[] args) {
        AbstractClass c;
        c = new ConcreteClassA();
        c.TemplateMethod();

        c= new ConcreteClassB();
        c.TemplateMethod();
    }
}
