package com.code.reflect;

public class Line {
    private static String s = getName();

    public Line() {
        System.out.println("构造函数");
    }

    private static String getName() {
        System.out.println("静态变量赋值");
        return "shan";
    }

    {
        System.out.println("普通代码块");
    }

    static {
        System.out.println("静态代码块：loading line");
    }
}
