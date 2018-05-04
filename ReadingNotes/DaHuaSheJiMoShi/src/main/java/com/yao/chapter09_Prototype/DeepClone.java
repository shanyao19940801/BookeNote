package com.yao.chapter09_Prototype;

/**
 * Created by shanyao on 2018/5/4.
 */
public class DeepClone implements Cloneable {
    private String name;

    public DeepClone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone ();
    }
}
