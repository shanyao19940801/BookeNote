package chapter08.threadfatory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by shanyao on 2018/4/9.
 * 自定义Thread添加其他功能
 */
public class MyAppThread extends Thread {
     public static final String DEFAULT_NAME = "MyAppThread";
     private static volatile boolean debugLifecycle = false;
     private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    private MyAppThread(Runnable r) {
        this(r,DEFAULT_NAME);
    }

    public MyAppThread(Runnable runnable, String name) {
        super(runnable, name + "-" + created.incrementAndGet());
        setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {

                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        log.log(Level.SEVERE, "UNCATCH in thread" + t.getName(), e);
                    }
                }
        );
    }

    public void run() {
        //复制debug标志以确保一致的值
        boolean debug = debugLifecycle;
        try {
            if (debug)
                log.log(Level.FINE, "Created " + getName());
            alive.incrementAndGet();
            super.run();
        } finally {
            alive.decrementAndGet();
            if (debug) {
                log.log(Level.FINE,"Exiting " + getName());
            }
        }
    }

    public static int getThreadCreated() {
        return created.get();
    }

    public static int getThreadsAlive() {
        return alive.get();
    }

    public static boolean getDegBug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean b) {
        debugLifecycle = b;
    }

}
