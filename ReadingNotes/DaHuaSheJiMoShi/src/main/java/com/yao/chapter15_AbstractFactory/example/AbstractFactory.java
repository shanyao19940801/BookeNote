package com.yao.chapter15_AbstractFactory.example;

/**
 * Created by shanyao on 2018/5/28.
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
