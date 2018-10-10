package com.thinkf.chapter10.c07;

public class Test1 implements ClassInInterface {
    @Override
    public void howdy() {
        System.out.println("Test1");
    }

    public static void main(String[] args) {
        ClassInInterface c = new Test1();
        c.howdy();
    }
}
