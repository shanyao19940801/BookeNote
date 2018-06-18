package jianzhi.capter02.c03;

/**
 * Created by shanyao on 2018/6/18.
 */
public class RectCover {
    public static int NumberOf1(int n) {
        int num = 0;
        int flag = 1;
        int a=0;
        while (flag != 0) {
            if ((n & flag) != 0)
                num++;
            flag = flag <<1;//当左移超过31变为0
            a++;
            System.out.println(flag);
        }
        return num;
    }
    //看剑指offerP81页，有多少个1就循环几次
    public static int NumberOf2(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf2(3));
        System.out.println(1&1);
    }

}
