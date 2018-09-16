package com.thinkf.chapter07.c08;

class B {
    public B() {
        System.out.println("b");
    }
}
class A {
    static B b = new B();
    B v1 = new B();
    static {
        System.out.println("static A");
    }
    public A() {
        System.out.println("A");
    }
}
class C {
    public C() {
        System.out.println("C");
    }
}
public class Bettle extends A {
    static C c = new C();

    static {
        System.out.println("static Bettle");
    }
    static void method() {
        System.out.println("static method A");
    }
    public Bettle() {
        System.out.println("Bettle");
    }

    public static void main(String[] args) {
        Bettle b = new Bettle();
        System.out.println("------");
        Bettle b1 = new Bettle();
    }
}
