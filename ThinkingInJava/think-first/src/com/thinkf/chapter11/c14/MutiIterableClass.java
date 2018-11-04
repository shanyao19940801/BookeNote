package com.thinkf.chapter11.c14;

import com.thinkf.chapter11.c13.IterableClass;

import java.util.*;

public class MutiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current  = worlds.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public String next() {
                        return worlds[current--];
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<>(Arrays.asList(worlds));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MutiIterableClass mic = new MutiIterableClass();
        for (String s : mic.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : mic.randomized())
            System.out.print(s + " ");
        System.out.println();
        for (String s : mic) {
            System.out.print(s + " ");
        }
    }
}
