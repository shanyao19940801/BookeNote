package com.thinkf.chapter09.c03;

public class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString () {
        return "Waveform" + id;
    }
}
