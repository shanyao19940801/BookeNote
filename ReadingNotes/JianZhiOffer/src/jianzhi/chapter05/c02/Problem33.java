package jianzhi.chapter05.c02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by shanyao on 2018/7/3.
 */
public class Problem33 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i < numbers.length; i ++) {
            lists.add(String.valueOf(numbers[i]));
        }
        Collections.sort(lists,new MyCompatable());
        StringBuffer res = new StringBuffer();
        for (String tem : lists) {
            res.append(tem);
        }
        return res.toString();
    }

    class MyCompatable implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String t1 = o1 + o2;
            String t2 = o2 + o1;
            for (int i =0; i < t1.length(); i++) {
                if (t1.charAt(i) > t2.charAt(i)) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Problem33 p  = new Problem33();
        int [] a = {32,12,14,55};
        System.out.println(p.PrintMinNumber(a));
    }
}


