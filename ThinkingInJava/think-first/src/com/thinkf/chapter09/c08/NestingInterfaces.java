package com.thinkf.chapter09.c08;

class A {
    interface B{
        void f();
    }
    public class BImp implements B {
        @Override
        public void f() {

        }
    }

    private class BImp2 implements B {
        @Override
        public void f() {

        }
    }
    public interface C {
        void f();
    }
    class CImp implements C {

        @Override
        public void f() {

        }
    }
    private class CImp2 implements C {
        @Override
        public void f() {

        }
    }
    private interface D {
        void f();
    }
    private class Dimp implements D {

        @Override
        public void f() {

        }
    }
    public class DImp2 implements D{
        @Override
        public void f() {

        }
    }
    public D getD(){
        return new DImp2();
    }

    private D dRef;
    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }

}
public class NestingInterfaces {
    public static void main(String[] args) {
        A a = new A();
//        A.D ad = a.getD(); 这里D是private
//        A.DImp2 di2 = a.getD();//不可以
//        a.getD().f();  不能使用interface中的方法
        A a2 = new A();
        a2.receiveD(a.getD());//只能用另外一个A去接受D
    }
}
