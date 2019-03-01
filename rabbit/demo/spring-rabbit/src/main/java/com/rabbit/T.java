package com.rabbit;

public class T {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
