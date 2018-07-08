package jianzhi.niuke;

import java.util.HashSet;

/**
 * Created by shanyao on 2018/7/8.
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0; i < length;i++) {
            int index = numbers[i]-length;
            if(index >= length) {
                duplication[0] = i;
                return true;
            } else if(index < 0) {
                index += length;
            }
            numbers[index] += length;

        }
        for (int i =0; i < length; i++) {
            if (numbers[i]>=length*2) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
        /*HashSet set = new HashSet();
        for(int i = 0; i < length; i++) {
            if(set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
            set.add(numbers[i]);
        }
        return false;*/
    }
    public static void main(String[] args) {
        int [] a = {2,1,3,1,4};
        Duplicate d = new Duplicate();
        int[] s = new int[1];
        d.duplicate(a,5,s);
        System.out.printf(String.valueOf(s[0]));

    }
}
