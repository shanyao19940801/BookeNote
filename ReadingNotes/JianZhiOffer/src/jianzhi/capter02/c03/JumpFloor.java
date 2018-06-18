package jianzhi.capter02.c03;

/**
 * Created by shanyao on 2018/6/18.
 */
public class JumpFloor {
    public static int jump(int n) {
        if (n < 3)
            return n;
        int fn1 = 1;
        int fn2 = 2;
        int fn= 3;
        /*一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。*/
        for (int i = 4;i<=n;i++) {
            fn = fn1 + fn2;
            fn1 = fn2;
            fn2 = fn;
        }
        return fn;
    }

    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法*/
    public static int JumpFloorII(int target) {
        if(target<3)
            return 3;
        if(target == 3)
            return 4;
        if(target == 4)
            return 7;
        int sum = 7;
        return 7 << (target-4);
    }


    public static void main(String[] args) {
        System.out.println(JumpFloorII(5));
    }
}
