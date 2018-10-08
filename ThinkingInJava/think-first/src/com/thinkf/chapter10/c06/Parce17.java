package com.thinkf.chapter10.c06;

import com.thinkf.chapter10.Contents;

/**
 * 匿名内部类
 */
public class Parce17 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parce17 p = new Parce17();
        Contents c = p.contents();
    }
}
