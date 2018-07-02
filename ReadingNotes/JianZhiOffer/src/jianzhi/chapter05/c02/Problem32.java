package jianzhi.chapter05.c02;

/**
 * Created by shanyao on 2018/7/2.
 */
public class Problem32 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0 || n < 0)
            return 0;
        int sum = 0;
        while (n > 0) {
            char [] c = String.valueOf(n).toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '1')
                    sum++;
            }
            n--;
        }
        return sum;
    }
}
