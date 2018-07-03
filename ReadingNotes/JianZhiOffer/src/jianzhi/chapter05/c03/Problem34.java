package jianzhi.chapter05.c03;

/**
 * Created by shanyao on 2018/7/3.
 */
public class Problem34 {
    public int GetUglyNumber_Solution(int index) {
        int [] ugly = new int[index];
        ugly[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        int ugnum = 1;
        while (ugnum < index) {
            int min = min(ugly[t2]*2,ugly[t3]*3,ugly[t5]*5);
            if (min > ugly[ugnum - 1]) {
                ugly[ugnum] = min;
            }
            while (ugly[t2]*2 <= ugly[ugnum]) {
                t2++;
            }
            while (ugly[t3]*3 <= ugly[ugnum]) {
                t3++;
            }
            while (ugly[t5]*5 <= ugly[ugnum]) {
                t5++;
            }
            ugnum++;
        }
        return ugly[ugnum-1];

    }

    public int min(int t1,int t3,int t5){
        int min = t1 < t3 ? t1 : t3;
        return min < t5 ? min :t5;

    }
    public int GetUglyNumber_Solution1(int index) {
        int num = 0;
        int count = 0;
        while(count< index) {

            if(judge(++num)) {
                System.out.println(num);
                count++;
            }
        }
        return num;
    }

    public boolean judge(int num){
        while(num%2==0){
            num /=2;
        }
        while(num%3==0) {
            num /= 3;
        }
        while(num%5==0) {
            num /= 5;
        }
        return num == 1 ? true : false;
    }

    public static void main(String[] args) {
        Problem34 p = new Problem34();
        System.out.println(p.GetUglyNumber_Solution(1500));
    }
}
