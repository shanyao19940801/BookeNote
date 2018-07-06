package jianzhi.chapter06.c04;

/**
 * Created by shanyao on 2018/7/6.
 */
public class Problem44 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0)
            return false;
        int max = 0;
        int min = 13;
        int [] pai  = new int[14];
        for(int i = 0; i<14; i++) {
            pai[i] = 0;
        }
        for(int i = 0; i < 5; i++) {
            int index = numbers[i];
            pai[index]++;
            if(index != 0 && pai[index] > 1) {
                return false;
            }

            if(index != 0 ) {
                if(index < min) {
                    min = index;
                }
            }
            if(index > max) {
                max = index;
            }
        }
        if((max-min - 1 <=0)||(max-min == 4)) {
            return true;
        }
        return false;

    }
}
