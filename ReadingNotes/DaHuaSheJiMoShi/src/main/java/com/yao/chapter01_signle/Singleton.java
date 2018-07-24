package com.yao.chapter01_signle;

/**
 * Created by user on 2018/7/24.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}