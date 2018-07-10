package jianzhi.zhenti;

/**
 * Created by shanyao on 2018/7/9.
 */
public class GetWays {
    public int countWays(int n) {
        // write code here
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return countWays(n)+countWays(n-1);
    }
}
