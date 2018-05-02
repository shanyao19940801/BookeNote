package com.yao.chapter07_daili.example;

/**
 * Created by shanyao on 2018/5/2.
 * 追求者
 */
public class Pursuit implements IGiveGift {
    SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    public void sendFlowers() {
        System.out.println("送花");
    }
}
