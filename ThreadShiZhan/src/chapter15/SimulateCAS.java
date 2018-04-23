package chapter15;

/**
 * Created by shanyao on 2018/4/23.
 */
public class SimulateCAS {
    private int value;
    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int execptedValue, int newValue) {
        int oldValue = value;
        if (oldValue== execptedValue)
            value = newValue;
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return (expectedValue == compareAndSwap(expectedValue, newValue));
    }
}
