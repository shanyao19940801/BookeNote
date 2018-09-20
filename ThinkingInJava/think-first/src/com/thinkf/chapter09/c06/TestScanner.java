package com.thinkf.chapter09.c06;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        String s1,s2;
        Scanner sc = new Scanner(System.in);
        System.out.println("shuru:");
        s1 = sc.next();
        sc.nextLine();
        System.out.println(s1);
    }
}
