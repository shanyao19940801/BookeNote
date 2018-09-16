package com.thinkf.chapter08.c02;
class Super{
    public int field = 0;

    public int getField() {
        return field;
    }
}
class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }
    public int getSuperField () {
        return super.field;
    }
}
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup.field = " + ((Sub) sup).field +
        ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " +
        sub.getField() +
        ", sub.getSuperField() = " +
        sub.getSuperField());
    }
}
