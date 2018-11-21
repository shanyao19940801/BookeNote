package com.thread;

public class Main {
    public static void main(String[] args) {
        SynchronizedTest t1 = new SynchronizedTest("a");
        SynchronizedTest t2 = new SynchronizedTest("b");

        t1.test();
        t2.test();

    }
}
