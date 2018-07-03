package jianzhi.chapter05.c03;

/**
 * Created by shanyao on 2018/7/3.
 */
public class Problem34 {
    public int GetUglyNumber_Solution(int index) {
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
        System.out.println(p.GetUglyNumber_Solution(10));
    }
}
