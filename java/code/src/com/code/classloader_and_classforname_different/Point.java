package com.code.classloader_and_classforname_different;

public class Point {
    static {
        System.out.println("静态代码块执行：loading point");
    }
}
