package com.yao.chapter10_TemplateMethod;

/**
 * Created by shanyao on 2018/5/5.
 */
public abstract class AbstractClass {
    public void baseMethod() {
        System.out.println("公用不需要重写的方法");
    }
    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();

    public void TemplateMethod() {
        PrimitiveOperation1();
        PrimitiveOperation2();
//        System.out.println("");
    }
}
