package chapter08.saturationpolicy;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by shanyao on 2018/4/8.
 */
public class ThreadPoolTest {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5,8,0L,
            TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(6));
    public static void main(String[] args) {
//        abort();
//        discard();
//        discardpolicyoldest();
//        callerruns();
        bondExecutorTest();
    }
    //通过信号量控制提交评率
    private static void bondExecutorTest() {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        BondedExecutor bondedExecutor = new BondedExecutor(threadPoolTest.executor,2);
        for (int i = 0; i < 50; i++) {
            System.out.println("main:"+i);
            try {
                bondedExecutor.submeitTask(new PrintTask(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //调用者运行
    //这里就是由主线程运行，这时候就会暂时提交任务
    private static void callerruns() {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 50; i++) {
            System.out.println("main:"+i);
            threadPoolTest.executor.execute(new PrintTask(i));
        }
    }

    //满了之后抛弃掉最新的提交的
    //所以这里要注意优先策略不要这个饱和策略一起使用
    private static void discardpolicyoldest() {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 50; i++) {
            System.out.println("main:"+i);
            threadPoolTest.executor.execute(new PrintTask(i));
        }
    }

    //满了之后再提交就抛弃掉
    private static void discard() {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 50; i++) {
            System.out.println("main:"+i);
            threadPoolTest.executor.execute(new PrintTask(i));
        }
    }

    //abort策略跑出一个异常
    private static void abort() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,8,0L,
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(5));
        for (int i = 0; i < 100; i++) {
            executor.execute(new PrintTask(i));
        }
    }

}
