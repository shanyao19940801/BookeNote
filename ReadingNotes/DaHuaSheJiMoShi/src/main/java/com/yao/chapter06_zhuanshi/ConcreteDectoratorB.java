package com.yao.chapter06_zhuanshi;

/**
 * Created by shanyao on 2018/4/30.
 */
public class ConcreteDectoratorB extends Decorator {
    public void operation () {
        super.operation();
        AddedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    private void AddedBehavior() {

    }
}
