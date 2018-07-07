package jianzhi.chapter06.c05;

/**
 * Created by shanyao on 2018/7/7.
 */
public class Problem47 {
    public int Add(int num1,int num2) {

        int sum = 0;
        int carry;
        do {
            //相加但不进位的结果
            sum = num1 ^ num2;
            //计算进位的值
            //相与之后同为1的进1
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while(carry != 0);//当没有进1时说明相加完成
        return num1;

    }

    
}
