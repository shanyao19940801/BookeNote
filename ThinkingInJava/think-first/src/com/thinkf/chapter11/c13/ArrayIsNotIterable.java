package com.thinkf.chapter11.c13;

import java.util.Arrays;

public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.println(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3));
        String[] strings = {"A", "B", "C"};
        //数组不能直接转换成Iterable
//        test(strings);
        test(Arrays.asList(strings));
    }
}
