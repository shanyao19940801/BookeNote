package jianzhi.capter02.c03;

/**
 * Created by user on 2018/3/1.
 * 替换空格
 * 将字符串中空格替换成%20
 * 自然想法，遇到空格就替换成'20%'，长度是n的字符串，遇到一个空格，就需要向后移动n个字符，所以时间复杂度为O（N^2)
 *
 * 【思路】
 * 双指针，从后往前遍历替换：
 *      p1：指向字符串末尾，
 *      p2：指向替换之后的字符串的末尾（需提前遍历一遍str，数一下一共有多少个空格）
 *  然后p1和p2一起向前跑，当p1遇到空格，则将' '变成'%20'，然后继续向前跑。
 *
 * Created by nibnait on 2016/9/20.
 */
public class Problem04 {


    public String replaceBlank(String orStr){

        char[] strNew = orStr.toCharArray();
        int size = strNew.length;
        for (int i = 0; i < strNew.length; i++) {
            if (' ' == strNew[i]) {
                size += 2;
            }
        }
        char[] strA = new char[size];
        int currentSize = size - 1;
        for (int i = strNew.length - 1;i >= 0; i--) {
            if (' ' == strNew[i]) {
                strA[currentSize--] = '0';
                strA[currentSize--] = '2';
                strA[currentSize--] = '%';
            } else {
                strA[currentSize--] = strNew[i];
            }
        }
        return new String(strA);
    }

    public static void main(String[] args) {
       String orStr = "We are happy";
        Problem04 p = new Problem04();
        System.out.println(p.replaceBlank(orStr));
    }
}
