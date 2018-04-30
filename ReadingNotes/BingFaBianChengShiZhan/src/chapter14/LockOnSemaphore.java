package chapter14;

import java.util.concurrent.Semaphore;

/**
 * Created by shanyao on 2018/4/21.
 */
public class LockOnSemaphore {
    private final Semaphore semaphore;

    public LockOnSemaphore() {
        this.semaphore = new Semaphore(1);
    }

    public void lock() {
        while (!semaphore.tryAcquire());
    }

    public void unlock() {
        semaphore.release();
    }
}
