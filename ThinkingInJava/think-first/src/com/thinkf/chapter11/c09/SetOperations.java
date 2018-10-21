package com.thinkf.chapter11.c09;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Collections.addAll(set1,
                "A B C D E F G H J K L".split(" "));

    }
}
