package com.yao.chapter19_Composite;

/**
 * Created by shanyao on 2018/6/2.
 * 对象生命接口
 * 在适当的情况下，实现所有类共有接口的默认行为。声明一个接口用于访问和管理Component的子部件
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract void display(int depth);
}
