package com.thinkf.chapter11.c13;

import java.util.Iterator;

public class IterableClass implements Iterable<String> {
    protected  String[] worlds = ("I an Shan Yao").split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < worlds.length;
            }

            @Override
            public String next() {
                return worlds[index++];
            }
        };
    }
}
