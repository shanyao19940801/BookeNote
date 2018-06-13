package com.yao.chapter26_Flyweight;

/**
 * Created by shanyao on 2018/6/13.
 */
public class FlyweightMain {
    public static void main(String[] args) {
        int extrinsicstate = 22;

        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("X");
        fx.Operation(--extrinsicstate);

        Flyweight fy = f.getFlyweight("Y");
        fy.Operation(--extrinsicstate);

        Flyweight fz = f.getFlyweight("Z");
        fz.Operation(--extrinsicstate);

        Flyweight uf = new UnsharedConcreteFlyweight();
        uf.Operation(--extrinsicstate);




    }
}
