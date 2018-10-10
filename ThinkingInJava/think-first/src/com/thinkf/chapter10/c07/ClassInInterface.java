package com.thinkf.chapter10.c07;

public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("HowDay");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }

}
