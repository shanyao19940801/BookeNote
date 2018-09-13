package com.thinkf.chapter07;

class Shape{
    Shape (int i) {
        System.out.println("Shape");

    }

    void dipose( ){
        System.out.println("Shape dispose");
    }
}
class Circle extends Shape {
    public Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }

    void dispose() {
        System.out.println("Erasing Circle");
        super.dipose();
    }
}
class Trianle extends Shape {

    Trianle(int i) {
        super(i);
        System.out.println("Drawing Trianle");
    }
    void dispose() {
        System.out.println("Erasing Trianle");
        super.dipose();
    }
}
class Line extends Shape {
    private int start,end;

    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing Line:" + start + ", " + end);
    }
    void dispose() {
        System.out.println("Erasing Line:" + start + ", " + end);
        super.dipose();
    }
}
public class CADSystem extends Shape{
    private Circle c;
    private Trianle t;
    private Line[] lines = new Line[3];


    CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j,j*i);

        }
        c = new Circle(1);
        t = new Trianle(1);
        System.out.println("Combined Con");

    }
    public void dispose() {
        System.out.println("CADSystem,dispose()");
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0;i--) {
            lines[i].dispose();
        }
        super.dipose();
    }

    public static void main(String[] args) {
        CADSystem x= new CADSystem(47);
        try {

        } finally {
            x.dispose();
        }
    }
}
