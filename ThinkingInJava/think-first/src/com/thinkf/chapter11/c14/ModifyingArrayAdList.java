package com.thinkf.chapter11.c14;

import java.util.*;

public class ModifyingArrayAdList {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] ia = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));//注意这里和下面第15行的不同
        System.out.println("Before shuffling: " + list1);
        Collections.shuffle(list1, rand);
        System.out.println("After shuffling: " + list1);
        System.out.println("array:" + Arrays.toString(ia));

        List<Integer> list2 = Arrays.asList(ia);//注意这里和上面第9行的不同
        System.out.println("Before shuffling: " + list2);
        list2.set(1,8);
        System.out.println("array: " + Arrays.toString(ia));
        Collections.shuffle(list2, rand);
        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(ia));

    }
}
