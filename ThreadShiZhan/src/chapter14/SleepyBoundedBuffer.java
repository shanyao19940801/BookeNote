package chapter14;

import common.Constants;

/**
 * Created by shanyao on 2018/4/19.
 */
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    protected SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                }
            }
            Thread.sleep(Constants.SLEEP_GRANULARITY);
        }
    }

    public V take () throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty()) {
                    return doTake();
                }
            }
            Thread.sleep(Constants.SLEEP_GRANULARITY);
        }
    }
}
