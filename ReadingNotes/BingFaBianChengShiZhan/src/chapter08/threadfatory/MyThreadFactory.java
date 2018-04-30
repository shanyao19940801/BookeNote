package chapter08.threadfatory;

/**
 * Created by shanyao on 2018/4/9.
 */
public class MyThreadFactory {
    private final String poolName;


    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}
