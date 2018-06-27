package jianzhi.chapter05.c01;

import java.util.HashMap;

/**
 * Created by shanyao on 2018/6/27.
 */
public class Problem29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0; i < array.length; i++) {
            if(map.containsKey(i)) {
                int temp = map.get(i);
                map.put(i,temp+1);
                if(map.get(i) > array.length/2) {
                    return i;
                }
            } else {
                map.put(i,0);
            }
        }
        return 0;
    }
}
