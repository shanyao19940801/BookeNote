package com.yao.chapter01_signle;

/**
 * Created by user on 2018/7/24.
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton() {
    }
    public static Singleton getSingleton() {
        if (instance == null) { // null 检测
            synchronized (Singleton.class) { // 同步检测
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}