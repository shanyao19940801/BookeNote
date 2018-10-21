package com.thinkf.chapter11.c09;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetOfInterger {
    public static void main(String[] args) {
        Random random = new Random(47);
        SortedSet inset = new TreeSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            inset.add(random.nextInt(30));
        }
        System.out.println(inset);
    }
}
