package com.yao.test;

import com.yao.consant.Constants;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by shanyao on 2018/4/30.
 */
public class Test {
    public static void main(String[] args) {
//        testreturn();
        test1();
    }

    private static void test1() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,100,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(300));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        long start = System.currentTimeMillis();
        for (int i=0; i < Constants.NUMBER; i++) {
//            System.out.println(i);
            /*if (executor.getQueue().size() >0) {
                continue;
            }*/
            executor.execute(new TestTask(i,start));
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }


    public static void testreturn() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,100,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(300));
        long start = System.currentTimeMillis();
        for (int i=0; i < Constants.NUMBER; i++) {
//            System.out.println(i);
            if (executor.getQueue().size() == 300) {
                continue;
            }
            executor.execute(new TestTask(i,start));
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
