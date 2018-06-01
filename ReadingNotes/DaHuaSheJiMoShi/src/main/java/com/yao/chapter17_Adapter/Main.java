package com.yao.chapter17_Adapter;

/**
 * Created by shanyao on 2018/6/1.
 */
public class Main {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
