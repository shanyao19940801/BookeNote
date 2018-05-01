package com.yao.chapter06_zhuanshi.example;

/**
 * Created by shanyao on 2018/5/1.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("小菜");
        System.out.println("第一种装扮");
        Sneakers sneakers = new Sneakers();
        BigTrouser bigTrouser = new BigTrouser();
        Tie tie = new Tie();
        TShirts shirts = new TShirts();
        sneakers.decorate(person);
        bigTrouser.decorate(sneakers);
        shirts.decorate(bigTrouser);
        shirts.show();
    }
}
