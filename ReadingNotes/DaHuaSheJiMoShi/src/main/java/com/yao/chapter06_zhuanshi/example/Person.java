package com.yao.chapter06_zhuanshi.example;

/**
 * Created by shanyao on 2018/5/1.
 */
public class Person {
    public Person() {

    }

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的"+name);
    }
}
