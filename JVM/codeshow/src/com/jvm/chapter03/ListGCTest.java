package com.jvm.chapter03;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by user on 2018/9/6.
 */
public class ListGCTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("1");
    }
}
