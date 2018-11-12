package com.code.reflect;

public class ClassloaderAndForNameTest {

    public static void main(String[] args) {
        String wholeNameLine = "com.code.reflect.Line";
        String wholeNamePoint = "com.code.reflect.Point";
        System.out.println("测试Classloader效果");
        testClassLoader(wholeNameLine, wholeNamePoint);
        System.out.println("--------------");
        System.out.println("测试Class.forName的效果");
        testForName(wholeNameLine, wholeNamePoint);
    }

    private static void testForName(String wholeNameLine, String wholeNamePoint) {
        try {
            Class line = Class.forName(wholeNameLine);
            Class point = Class.forName(wholeNamePoint);
            System.out.println("line " + line.getName());
            System.out.println("point " + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testClassLoader(String whileNameLine, String whileNamePoint) {
        Class<?> line;
        Class<?> point;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            line = loader.loadClass(whileNameLine);
            point = loader.loadClass(whileNamePoint);
            System.out.println("line " + line.getName());
            System.out.println("point " + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
