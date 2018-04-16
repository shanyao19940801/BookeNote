package chapter10;

import org.junit.Test;

/**
 * Created by shanyao on 2018/4/16.
 */
public class Code_12_3 {
    @Test
    public void testTakeBlockWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        Thread taker = new Thread() {
            public void run() {
                try {
                    int unused = bb.take();
                    fail();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        try {
            taker.start();
            Thread.sleep(10000);
            taker.interrupt();
            taker.join(10000);
            assert taker.isAlive();
        } catch (InterruptedException e) {
            fail();
        }
    }

    private void fail() {
        System.out.println("false");
    }
}
