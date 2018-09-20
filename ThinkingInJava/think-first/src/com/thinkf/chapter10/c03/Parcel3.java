package com.thinkf.chapter10.c03;

public class Parcel3 {
    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }
    class Destination {
        private String level;

        public Destination(String level) {
            this.level = level;
        }
        String readLable() {
            return level;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Contents c = p.new Contents();
        Parcel3.Destination d = p.new Destination("Tasmaia");
    }
}
