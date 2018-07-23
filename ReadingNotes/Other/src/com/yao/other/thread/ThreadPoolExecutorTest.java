package com.yao.other.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by shanyao on 2018/7/23.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1000),
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "downLoadMoveInfoExector " + r.hashCode());
                    }
                });
    }
}
