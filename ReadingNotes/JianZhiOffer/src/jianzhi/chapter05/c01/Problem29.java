package jianzhi.chapter05.c01;

import java.util.HashMap;

/**
 * Created by shanyao on 2018/6/27.
 */
public class Problem29 {

    //解法二：基于Partition算法的O(n)算法
    public int MoreThanHalfNum_Solution2(int [] array) {
        
        return 0;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0; i < array.length; i++) {
            if(map.containsKey(array[i])) {
                int temp = map.get(array[i]);
                map.put(array[i],temp+1);
                if(map.get(array[i]) > array.length/2) {
                    return array[i];
                }
            } else {
                map.put(array[i],0);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem29 p = new Problem29();
        int [] a = {1,2,3,2,2,2,5,4,2};
        int r = p.MoreThanHalfNum_Solution(a);
        System.out.println(r);
    }
}
