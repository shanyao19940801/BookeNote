package com.thinkf.chapter07;

public class SprinklerSystem {
    private String v1,v2,v3,v4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "v1='" + v1 + '\'' +
                ", v2='" + v2 + '\'' +
                ", v3='" + v3 + '\'' +
                ", v4='" + v4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}
