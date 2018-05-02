package com.yao.chapter07_daili.example;

/**
 * Created by shanyao on 2018/5/2.
 * 代理送礼物
 */
public class ProxySend implements IGiveGift{

    private Pursuit pursuit;

    public ProxySend(SchoolGirl schoolGirl) {
        this.pursuit = new Pursuit(schoolGirl);
    }

    public void sendFlowers() {
        pursuit.sendFlowers();
    }
}
