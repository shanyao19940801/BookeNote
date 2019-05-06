package com.example.demo;

import org.junit.Test;

/**
 * Created by sunyunhao on 2019/4/29.
 */
public class MyTest {
    @Test
    public void test(){
        String s = String.format("123%s%%)", 12);
        System.out.println(s);
    }
}
