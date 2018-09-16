package com.thinkf.chapter08.c03;

class Glyph {
    void draw() {
        System.out.println("Glyph.draw();");
    }

    public Glyph() {
        System.out.println("Glyph() befor draw()");
        //因为子类RoundGlyph覆盖了draw方法，这里将会导致子类还没有完全构造完成就进行调用
        //所以这里输出radius的值是0而不是1
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(), radis = " + radius);
    }

    void draw(){
        System.out.println("RoundGlyph.RoundGlyph(), radis = " + radius);
    }
}
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
