package jianzhi.chapter03.c03;

/**
 * Created by shanyao on 2018/6/19.
 * 输入n，打印1到n的最大位数，
 * 注意n没有限制，所以避免数字过大需要使用字符的形式打印
 */
public class Problem12 {

    /**
     * 解法一，利用字符模拟数字加
     * @param n
     */
    public static void print(int n){
        char [] num = new char[n];
        while (!(increment(num))) {
            System.out.println(num);
        }
    }

    public static boolean increment(char[] num){
        boolean isOK = false;
        int len = num.length;
        int add = 0;
        for (int i = len-1;i>=0;i--) {
            if (num[i] == '\0')
                num[i] = '0';
            add = num[i] - '0';
            add++;
            if (add >=10) {
                if (i==0)
                    return true;
                num[i] = '0';
                continue;
            } else {
                num[i] = (char) (add + '0');
                return false;
            }
        }
        return isOK;

    }
    ///*******方法一
    ///*******方法二

    /**
     * 方法二 利用数字全排列打印
     * @param n
     */
    public static void print2(int n) {
        if (n <= 0)
            return;
        char[] num = new char[n];

        for (int i = 0; i < 10; i++) {
            num[0] = (char) (i + '0');
            printToMax(num, n, 0);
        }

    }

    public static void printToMax(char[] num, int n,int index) {
        if (index == n-1) {
            printNum(num);
            return;
        }

        for (int i = 0; i < 10;i++) {
            num[index+1] = (char) (i + '0');
            printToMax(num, n, index+1);
        }
    }

    private static void printNum(char[] num) {
        boolean begin = false;
        for (int i = 0; i < num.length; i++) {
            if (!begin && num[i] != '0') {
                begin = true;
            }
            if (begin)
                System.out.print(num[i]);
        }
        if (begin)
            System.out.println();
//        System.out.println(num);
    }


    public static void main(String[] args) {
//        print(3);
        print2(2);
    }


}
