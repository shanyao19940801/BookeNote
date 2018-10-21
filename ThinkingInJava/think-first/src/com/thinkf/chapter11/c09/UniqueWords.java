package com.thinkf.chapter11.c09;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(
                new TextFile("F:\\proects\\booknote\\ThinkingInJava\\think-first\\src\\com\\thinkf\\chapter11\\c09\\SetOperations.java","\\W+")
        );
        System.out.println(words);
    }
}
