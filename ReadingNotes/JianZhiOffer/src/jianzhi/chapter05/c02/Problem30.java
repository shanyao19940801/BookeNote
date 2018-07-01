package jianzhi.chapter05.c02;

import java.util.*;

/**
 * Created by shanyao on 2018/7/1.
 */
public class Problem30 {
    /*public class MyComparetor implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }*/
    //方法一：
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length < k || k ==0) {
            return list;
        }
        int max = input[0];
        for(int i = 0; i < input.length; i++) {
            if (i<k) {
                if (max < input[i]) {
                    max = input[i];
                }
                list.add(input[i]);
                continue;
            }
            if (input[i] < max) {
                list.remove(list.indexOf(max));
                list.add(input[i]);
                max = getMax(list);
            }
        }
        return list;
    }

    public int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            max = list.get(i) > max ? list.get(i) : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int [] t = {4,5,1,6,2,7,3,8};
        Problem30 p = new Problem30();
        ArrayList list = p.GetLeastNumbers_Solution(t,4);
        System.out.println(list);

    }
}
