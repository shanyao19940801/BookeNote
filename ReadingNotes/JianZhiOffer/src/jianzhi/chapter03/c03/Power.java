package jianzhi.chapter03.c03;

/**
 * Created by shanyao on 2018/6/18.
 */
public class Power {
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        double result = base;
        int me = Math.abs(exponent);
        for (int i = 0; i < me - 1; i++) {
            result = result * base;
        }

        return exponent < 0 ? 1/result : result;
    }
    public static double Power1(double base, int exponent) {
        if(exponent== 0)
                return 1;
        double result = base;
        int me = Math.abs(exponent);
        result = power1(base,me);

        return exponent < 0 ? 1/result : result;
    }


    /*递归解法
    *
    * */
    public static double power1(double base, int exponent){

        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double result = power1(base,exponent>>1);
        result *= result;
        if((exponent&1)==1)
            result *= base;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power1(2,3));
    }
}
