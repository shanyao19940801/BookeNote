package com.thinkf.chapter10.c07;

public class MutilNestingAcess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A a = mna.new A();
        MNA.A.B b = a.new B();
        b.h();
    }
}
