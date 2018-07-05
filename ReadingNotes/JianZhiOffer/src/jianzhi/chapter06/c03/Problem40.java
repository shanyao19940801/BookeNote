package jianzhi.chapter06.c03;

/**
 * Created by shanyao on 2018/7/5.
 */
public class Problem40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length < 2 || array.length % 2 == 1)
            return;
        int resultBit = 0;
        for (int i = 0; i < array.length; i++) {
            resultBit ^= array[i];
        }
        int index = findFirstBitIs1(resultBit);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i],index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    //找到一个数字的二进制的第一个为1的下标（从右往左）
    public int findFirstBitIs1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }
    //判断num的二进制的第index位是否为1，是返回 true 否 返回 false
    public boolean isBit(int num, int index) {
        int n = num >> index;
        return ((n&1) == 1);
    }

    public static void main(String[] args) {
        Problem40 p = new Problem40();
        int a[] = {2,4,3,6,3,2,5,5};
        int [] n1 = new int[1];
        int [] n2 = new int[1];
        int result = 0;
        result ^= 2;
        System.out.println(result);
    }
}
