package com.yao.other.jvm.jvm01;

/**
 * Created by shanyao on 2018/7/24.
 */
public class OrderiniteSon extends Orderinit {
    public Print p = new Print("--非静态===子类");
    public static Print p1 = new Print("--静态===子类");
    public OrderiniteSon() {
        System.out.println("构造函数===子类");
    }

    static {
        System.out.println("静态代码块===子类");
    }

    public static void main(String[] args) {
        OrderiniteSon oson = new OrderiniteSon();
    }
}
