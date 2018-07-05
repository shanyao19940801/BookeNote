package jianzhi.chapter06.c03;

/**
 * Created by shanyao on 2018/7/5.
 */
public class Problem42 {
    public String ReverseSentence(String str) {
        StringBuffer strb = new StringBuffer(str);
        revert(strb,0,str.length()- 1);
        int start = 0;
        int end = 1;
        while (end < strb.length()) {
            if (strb.charAt(end) == ' ') {
                revert(strb,start,end-1);
                start = end + 1;
            }
            end++;
        }
        revert(strb,start,end-1);
        return strb.toString();
    }
    public void revert(StringBuffer str,int start, int end) {

        while (start < end) {
            char temp = str.charAt(start);
            str.setCharAt(start,str.charAt(end));
            str.setCharAt(end,temp);
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        Problem42 p = new Problem42();
        String str = "I am a student.";
        p.ReverseSentence(str);
    }
}
