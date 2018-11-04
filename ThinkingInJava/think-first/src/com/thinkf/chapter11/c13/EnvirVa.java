package com.thinkf.chapter11.c13;

import java.util.Map;

public class EnvirVa {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
