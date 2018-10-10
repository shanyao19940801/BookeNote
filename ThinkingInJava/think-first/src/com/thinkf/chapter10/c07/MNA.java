package com.thinkf.chapter10.c07;

public class MNA {
    private void f() {}
    class A {
        private void g(){}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}
