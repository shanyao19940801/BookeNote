package com.scheduledexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
//        test1();
        testScheduledThreadPool();
    }

    public static void testScheduledThreadPool() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //基于线程池多任务执行，互不影响
        service.scheduleAtFixedRate(new MyScheduledExecutor("job1"), 0, 2, TimeUnit.SECONDS);//每隔2s执行一次
        service.scheduleAtFixedRate(new MyScheduledExecutor("job2"), 0, 4, TimeUnit.SECONDS);//每隔4s执行一次
    }

    public static void testSingleThreadScheduledExecutor() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("a");
            }
        }, 2, 2, TimeUnit.SECONDS);
    }
}
