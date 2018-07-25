package com.yao.other.jvm.jvm01;

/**
 * Created by shanyao on 2018/7/24.
 */
public class Orderinit {
    public Print p = new Print("--非静态==父类");
    public static Print p1 = new Print("--静态==父类");
    public Orderinit() {
        System.out.println("构造函数==父类");
    }

    static {
        System.out.println("静态代码块==父类");
    }
    public static void main(String[] args) {
        Orderinit o = new Orderinit();

    }
}
