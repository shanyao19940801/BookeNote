package com.yao.chapter07_daili.example;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shanyao on 2018/5/2.
 */
public class ExampleMain {
    public static void main(String[] args) {
        SchoolGirl jiaojia = new SchoolGirl();
        jiaojia.setName("mm");
        ProxySend proxySend = new ProxySend(jiaojia);
        proxySend.sendFlowers();
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.size();
    }
}
