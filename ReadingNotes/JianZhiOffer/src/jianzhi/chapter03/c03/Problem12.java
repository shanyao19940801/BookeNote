package jianzhi.chapter03.c03;

/**
 * Created by shanyao on 2018/6/19.
 */
public class Problem12 {
    public static void print(int n){
        char [] num = new char[n];
        while (!(increment(num))) {
            System.out.println(num);
        }
    }

    public static boolean increment(char[] num){
        boolean isOK = false;
        int len = num.length;
        int add = 0;
        for (int i = len-1;i>=0;i--) {
            if (num[i] == '\0')
                num[i] = '0';
            add = num[i] - '0';
            add++;
            if (add >=10) {
                if (i==0)
                    return true;
                num[i] = '0';
                continue;
            } else {
                num[i] = (char) (add + '0');
                return false;
            }
        }
        return isOK;

    }
    public static void main(String[] args) {
        print(3);
    }
}
