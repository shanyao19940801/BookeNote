package com.yao.chapter26_Flyweight.example;

/**
 * Created by shanyao on 2018/6/13.
 * 用户类，用于网站的客户账号，是"网站"类的外部状态
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
