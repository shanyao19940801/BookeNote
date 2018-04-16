package chapter10;

import net.jcip.annotations.GuardedBy;

import java.util.concurrent.Semaphore;

/**
 * Created by shanyao on 2018/4/16.
 */
public class BoundedBuffer<E> {
    private final Semaphore availableItems, availableSpace;
    @GuardedBy("this") private final E[] items;
    @GuardedBy("this") private int putPosition = 0, takePosition = 0;
    public BoundedBuffer(int capactity) {
        availableItems = new Semaphore(0);
        availableSpace = new Semaphore(capactity);
        items = (E[]) new Object[capactity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpace.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        availableSpace.acquire();
        doInsert(x);
        availableItems.release();
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = dExtract();
        availableSpace.release();
        return item;
    }

    private E dExtract() {
        int i  = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? 0 : i;
        return x;
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;  //TODO
    }


}
