package chapter10;

/**
 * Created by shanyao on 2018/4/16.
 */
public class Utils {
    static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >> 21);
        y ^= (y << 7);
        return y;
    }
}
