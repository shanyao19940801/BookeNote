package com.yao.test;

import java.util.LinkedList;

/**
 * Created by shanyao on 2018/7/18.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        int a = l.pop();
        int b = l.pop();
        System.out.println(b);
    }
}
