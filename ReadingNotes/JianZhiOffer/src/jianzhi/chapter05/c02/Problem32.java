package jianzhi.chapter05.c02;

/**
 * Created by shanyao on 2018/7/2.
 */
public class Problem32 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0)
            return 0;
        String str = String.valueOf(n);
        return getSum(new StringBuffer(str));
    }

    public int getSum(StringBuffer str){
        if (str == null || str.length() == 0)
            return 0;
        int first = str.charAt(0) - '0';
        int len = str.length();
        if (first == 0 && len == 1)
            return 0;
        if (len == 1 && first > 0)
            return 1;
        int maxSum = 0;
        if (first > 1) {
            maxSum = power(len - 1);
        } else if (first == 1) {
            maxSum = Integer.valueOf(str.substring(1)) + 1;
        }

        int secSum = 0;
        secSum = first*(len-1)* power(len - 2);

        return maxSum + secSum + getSum(new StringBuffer(str.substring(1)));
    }

    //计算除去最大位的值
    int cout(StringBuffer a) {
        int len = a.length();
        int ji = power(len-1);
        String str = a.toString();
        Integer num = Integer.valueOf(str);
        return num%ji;
    }
    int power(int l) {
        int sum = 1;
        for (int i =0;i<l;i++) {
            sum *= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem32 p = new Problem32();
        int i = p.NumberOf1Between1AndN_Solution(10000);
        System.out.println(i);
    }
    //方法一：比较笨时间复杂度为
    /*public int NumberOf1Between1AndN_Solution(int n) {
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
    }*/
}
