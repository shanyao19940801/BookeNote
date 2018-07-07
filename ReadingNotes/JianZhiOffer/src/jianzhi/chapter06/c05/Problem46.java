package jianzhi.chapter06.c05;

/**
 * Created by shanyao on 2018/7/7.
 */
public class Problem46 {
    public int Sum_Solution(int n) {
        int sum = n;
        //这里利用&&阻断的特殊写法，当n=0就不会去执行后面递归了
        boolean flag = (n>0)&&((sum+=Sum_Solution(n-1))>0);

        return sum;
    }

    public static void main(String[] args) {
        Problem46 p = new Problem46();
        int sum = p.Sum_Solution(3);
        System.out.println(sum);

        Test46 [] t = new Test46[4];

    }
}
