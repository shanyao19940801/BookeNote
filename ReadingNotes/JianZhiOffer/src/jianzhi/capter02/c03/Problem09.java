package jianzhi.capter02.c03;

/**
 * Created by shanyao on 2018/6/18.
 */
public class Problem09 {
    public static int Fibonacci(int n) {
        if(n<2){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Fibonacci(35));
        long mid = System.currentTimeMillis();
        System.out.println(start - mid);
        System.out.println(Fbonacci01(135));
        System.out.println(mid - System.currentTimeMillis());
    }

    public static int Fbonacci01(int n) {
        if (n < 2)
            return n;
        int fn1 = 0;
        int fn2 = 1;
        int fn = fn1 + fn2;
        for (int i = 2;i<=n;i++) {
            fn = fn1 + fn2;
            fn1 = fn2;
            fn2 = fn;
        }
        return fn;
    }

}
