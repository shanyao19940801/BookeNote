package com.yao.chapter13_Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanyao on 2018/5/9.
 */
public class Product {
    List<String> parts = new ArrayList<String>();

    public void addPartt(String part) {
        parts.add(part);
    }

    public void show(){
        System.out.println("产品部件");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
