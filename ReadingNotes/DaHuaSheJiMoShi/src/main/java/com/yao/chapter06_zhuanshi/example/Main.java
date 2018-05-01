package com.yao.chapter06_zhuanshi.example;

/**
 * Created by shanyao on 2018/5/1.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("小菜");
        System.out.println("第一种装扮");
        Sneakers pqx = new Sneakers();
        BigTrouser kk = new BigTrouser();
        TShirts dtx = new TShirts();
        pqx.decorate(person);
        kk.decorate(pqx);
        dtx.decorate(kk);
        dtx.show();
    }
}
