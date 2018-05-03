package com.yao.test;

/**
 * Created by shanyao on 2018/5/3.
 */
public class TestTask implements Runnable {
    private int i;
private long starttime;
    public TestTask(int i,long starttime) {
        this.i = i;
        starttime = starttime;
    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第"+i+"个线程，"+"时间差：" + (this.starttime - System.currentTimeMillis()));
    }
}
