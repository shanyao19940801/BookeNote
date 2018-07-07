package jianzhi.chapter06.c04;

import jianzhi.Standard.ListNode;

/**
 * Created by shanyao on 2018/7/6.
 */
public class Problem45 {
    public int LastRemaining_Solution(int n, int m) {
        if(n == 1) {
            return 0;
        }
        int [] num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = i;
        }

        int leftNum = n;
        int in = 0;
        while(leftNum>1) {
            int count = 0;
            in %= n;
            while(count<m) {
                if(num[in++%n]== -1) {
                    continue;
                }
                count++;
            }

            num[(in-1)%n] = -1;
            leftNum--;
        }
        for(int i =0; i< n; i++) {
            if(num[i] != -1)
                return num[i];
        }
        return 0;

    }

    public static void main(String[] args) {
        Problem45 p = new Problem45();
        int l = p.LastRemaining_Solution(5,3);
        System.out.println(l);
    }
}
