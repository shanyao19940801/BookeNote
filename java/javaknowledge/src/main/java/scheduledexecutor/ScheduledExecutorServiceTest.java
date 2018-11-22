package scheduledexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
//        testScheduledThreadPool();
        testSingleThreadScheduledExecutor();
    }

    public static void testScheduledThreadPool() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //基于线程池多任务执行，互不影响
        service.scheduleAtFixedRate(new MyScheduledExecutor("job1"), 0, 2, TimeUnit.SECONDS);//每隔2s执行一次
        service.scheduleAtFixedRate(new MyScheduledExecutor("job2"), 0, 4, TimeUnit.SECONDS);//每隔4s执行一次
    }

    public static void testSingleThreadScheduledExecutor() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        //每次执行时间为上一次任务开始起向后推一个时间间隔
        service.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("a");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 2, 2, TimeUnit.SECONDS);


        //每次执行时间为上一次任务结束起向后推一个时间间隔
        service.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("b");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 2, 2, TimeUnit.SECONDS);

    }
}
