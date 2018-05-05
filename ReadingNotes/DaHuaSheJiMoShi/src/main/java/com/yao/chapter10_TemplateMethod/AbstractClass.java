package com.yao.chapter10_TemplateMethod;

/**
 * Created by shanyao on 2018/5/5.
 */
public abstract class AbstractClass {
    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();

    public void TemplateMethod() {
        PrimitiveOperation1();
        PrimitiveOperation2();
//        System.out.println("");
    }
}
