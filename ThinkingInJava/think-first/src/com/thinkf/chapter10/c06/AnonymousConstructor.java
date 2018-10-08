package com.thinkf.chapter10.c06;

abstract class Base {
    public Base(int i) {
        System.out.println("Base Constructor,i=" + i);
    }
    public abstract void f();
}
public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {System.out.println("Inside instacnce initizer");}
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
