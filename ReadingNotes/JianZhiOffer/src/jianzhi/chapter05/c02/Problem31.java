package jianzhi.chapter05.c02;

/**
 * Created by shanyao on 2018/7/2.
 */
public class Problem31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = array[0];
        int sum = max;
        for (int i = 1; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];

            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem31 p = new Problem31();
        int [] s = {-2,-8,-1,-5,-9};
        p.FindGreatestSumOfSubArray(s);
    }
}
