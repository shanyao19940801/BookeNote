package jianzhi.chapter06.c05;

/**
 * Created by shanyao on 2018/7/7.
 */
public class Problem48 {
    public int StrToInt(String str) {
        StringBuffer s = new StringBuffer(str);
        int len = str.length();
        if(len < 1)
            return 0;
        int sum = 0;
        int j = 1;
        for(int i = len-1; i > 0; i--) {
            char tem = str.charAt(i);
            if( tem < '0' || tem > '9')
                return 0;
            sum += (j*(tem - '0'));
        }
        char fist = s.charAt(0);
        if (fist == '-') {
            return 0-sum;
        }
        if (fist == '+')
            return sum;
        if (fist < '0' || fist > '9')
            return 0;
        return sum + ((fist-'0')*j);
    }

    public static void main(String[] args) {
        Problem48 p = new Problem48();
        p.StrToInt("124");
    }
}
