package com.yao.chapter26_Flyweight.example;

/**
 * Created by shanyao on 2018/6/13.
 */
public class ConcreteWebSite extends WebSite {
    private String name;

    public ConcreteWebSite(String name) {
        this.name = name;
    }

    public void Use(User user) {
        System.out.println("网站分类：" + name + " 用户：" + user.getName());
    }


}
