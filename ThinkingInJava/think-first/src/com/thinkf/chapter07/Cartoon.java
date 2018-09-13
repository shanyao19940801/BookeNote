package com.thinkf.chapter07;


class Art{
    public Art() {
        System.out.println("Art()");
    }
}
class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing()");
    }
}
public class Cartoon extends Drawing{
    public Cartoon() {
        System.out.println("Cartoon()");
    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
