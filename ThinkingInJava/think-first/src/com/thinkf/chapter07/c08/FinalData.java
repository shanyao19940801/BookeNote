package com.thinkf.chapter07.c08;

import java.util.Arrays;
import java.util.Random;

class Value {
    int i;
    public Value(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Value{" +
                "i=" + i +
                '}';
    }
}
public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1= new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    private final int[] a = {1,2,3,4,5,6};

    @Override
    public String toString() {
        return "FinalData{" +
                "id='" + id + '\'' +
                ", valueOne=" + valueOne +
                ", i4=" + i4 +
                ",INT_5" + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        //fd1.valueOne++;//final修饰的不能被修改
        fd1.v2.i++;//v2虽然是final类型但是它是一个引用类型，其引用不可被修改但是引用的值可以修改
        fd1.v1 = new Value(0);
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
        //fd1.v2 = new Value(0);//v2是final这样相当于修改其引用了所以error
//        fd1.VAL_3 = new Value(3);是final这样相当于修改其引用了所以error
        System.out.println(fd1);
        System.out.println("Creating new Date");
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }
}
