package jianzhi.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shanyao on 2018/7/5.
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(sum < 3)
            return lists;
        int end = sum/2 + 1;
        int start = 1;
        while (!isEnd(sum,start)) {
            start++;
        }
        while(start <= end) {
            int index = start;
            ArrayList<Integer> list = new ArrayList();
            int tempSum = 0;
            while(tempSum < sum ) {
                list.add(index);
                tempSum += index;
                index--;
            }
            if(tempSum == sum) {
                Collections.sort(list,new MyComtrator());
                lists.add(list);
            }
            start++;
        }
        return lists;
    }



    boolean isEnd(int sum,int index) {
        if(index*(index+1) < 2*sum){
            return false;
        }
        return true;
    }

    static class MyComtrator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {

            return o1 > o2 ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        FindContinuousSequence f = new FindContinuousSequence();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        Collections.sort(list,new MyComtrator());
        list.add(2);
    }
}
