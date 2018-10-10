package com.thinkf.chapter10.c08;
interface Incrementable {
    void increment();
}

class Calleel implements Incrementable {

    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}
class Callee2 extends MyIncrement {
    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    //注意这里，因为外围类继承了MyIncrement而其中有一个方法与接口Incrementable相同的，
    // 为了不被覆盖掉，这里通过内部类来实现
    private class Closure implements Incrementable {

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCllbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;

    public Caller(Incrementable callbackReference) {
        this.callbackReference = callbackReference;
    }
    void go() {
        callbackReference.increment();
    }
}
public class Callbacks {
    public static void main(String[] args) {
        Calleel c1 = new Calleel();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCllbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
