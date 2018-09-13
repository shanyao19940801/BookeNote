package com.thinkf.chapter07;

public class WaterSource {
    private String s;

    public WaterSource() {
        System.out.println("WaterSource()");
        s = "Cont";
    }

    @Override
    public String toString() {
        return s;
    }
}
