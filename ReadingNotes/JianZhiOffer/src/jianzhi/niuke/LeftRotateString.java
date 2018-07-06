package jianzhi.niuke;

/**
 * Created by shanyao on 2018/7/6.
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(n<0 || n>str.length()) {
            return "";
        }
        int len = str.length();
        StringBuffer strb = new StringBuffer(str);
        revert(strb,0,len-1);
        revert(strb,0,str.length()-n-1);
        revert(strb,str.length()-n,str.length()-1);
        return strb.toString();
    }

    void revert(StringBuffer str,int start, int end) {

        while(start < end) {
            char temp = str.charAt(start);
            str.setCharAt(start,str.charAt(end));
            str.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}
