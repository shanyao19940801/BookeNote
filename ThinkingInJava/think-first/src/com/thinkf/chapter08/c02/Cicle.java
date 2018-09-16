package com.thinkf.chapter08.c02;

class Shape {
    public void draw() {
        System.out.println("Shape");
    }
}
public class Cicle extends Shape{
    public void draw() {
        System.out.println("Cicle");
    }

    public static void main(String[] args) {
        Shape s = new Cicle();
        s.draw();
    }
}
