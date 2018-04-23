package chapter15;

/**
 * Created by shanyao on 2018/4/23.
 */
public class CasCounter {
    private SimulateCAS value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        }
        while (v != value.compareAndSwap(v, v+1));
        return v + 1;
    }
}
