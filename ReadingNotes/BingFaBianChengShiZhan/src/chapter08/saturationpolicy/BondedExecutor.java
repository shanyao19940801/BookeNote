package chapter08.saturationpolicy;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by shanyao on 2018/4/9.
 */
public class BondedExecutor {
    private final Executor executor;
    private final Semaphore semaphore;

    public BondedExecutor(Executor executor, Semaphore semaphore) {
        this.executor = executor;
        this.semaphore = semaphore;
    }

    public BondedExecutor(Executor executor, int i) {
        this(executor,new Semaphore(i));
    }

    public void submeitTask(final Runnable commond) throws InterruptedException {
        semaphore.acquire();
        try {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        commond.run();
                    } finally {
                        System.out.println("执行完成 ，release...");
                        semaphore.release();
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("队列已满");
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        BondedExecutor bondedExecutor = new BondedExecutor(executor, 2);
    }
}
