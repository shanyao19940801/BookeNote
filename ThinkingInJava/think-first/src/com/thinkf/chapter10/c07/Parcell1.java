package com.thinkf.chapter10.c07;

import com.thinkf.chapter10.Contents;
import com.thinkf.chapter10.Destination;


public class Parcell1 {
    private static class ParcelContents implements Contents {

        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {

        private String label;

        public ParcelDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {}

        static int x = 10;
        static class AnotherLevel {
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmaina");
        ParcelDestination p = new ParcelDestination("tt");
    }
}
