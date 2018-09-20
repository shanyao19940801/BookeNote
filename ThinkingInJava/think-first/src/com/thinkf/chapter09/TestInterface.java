package com.thinkf.chapter09;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class TestInterface {
    interface TInter{
        int data = 1;
        void test();
    }
    public static void main(String[] args) {
        Class obj = TInter.class;
        try {
            System.out.println(TInter.data);
            Field field = obj.getField("data");
            System.out.println("修饰符："+Modifier.toString(field.getModifiers()));
            Method method = obj.getMethod("test");
            System.out.println("方法修饰符："+Modifier.toString(field.getModifiers()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
