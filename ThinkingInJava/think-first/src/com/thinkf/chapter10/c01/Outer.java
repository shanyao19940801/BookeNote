package com.thinkf.chapter10.c01;

public class Outer {
    class Inner {
        public void test() {
            System.out.println("inner");
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner1 = outer.getInner();
        inner.test();
    }
}
