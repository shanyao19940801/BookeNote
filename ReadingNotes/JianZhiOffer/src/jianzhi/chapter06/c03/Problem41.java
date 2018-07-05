package jianzhi.chapter06.c03;

import java.util.ArrayList;

/**
 * Created by shanyao on 2018/7/5.
 */
public class Problem41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList();
        if(array.length == 0){
            return list;
        }

        int end = array.length - 1;
        while(array[end] > sum) {
            end--;
        }
        if(end < 0)
            return list;
        int start = 0;
        while(start < end){
            int temp = array[start] + array[end];
            if(temp > sum) {
                end--;
            } else if(temp < sum) {
                start++;
            } else {
                list.add(array[start]);
                list.add(array[end]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Problem41 p = new Problem41();
        int [] a = {1,2,3,4,5};
        int sum = 5;
        p.FindNumbersWithSum(a,sum);
        System.out.println();
    }
}
