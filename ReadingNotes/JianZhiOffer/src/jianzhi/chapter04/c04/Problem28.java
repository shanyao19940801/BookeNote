package jianzhi.chapter04.c04;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by shanyao on 2018/6/26.
 */
public class Problem28 {
    //方法一：
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        TreeSet set = new TreeSet();
        if (str == null) {
            return arrayList;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        add(stringBuffer,0,set);
        arrayList = new ArrayList<>(set);
        return arrayList;
    }

    public void add(StringBuffer str, int begin, TreeSet treeSet){
        int len = str.length();
        if (begin == len) {
            return;
        }
        for (int i = begin;i<len;i++) {
            char temp = str.charAt(begin);
            str.setCharAt(begin,str.charAt(i));
            str.setCharAt(i,temp);
            treeSet.add(str.toString());
            add(str,begin+1,treeSet);
            str.setCharAt(i,str.charAt(begin));
            str.setCharAt(begin,temp);
        }

    }
    //方法二：
    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null) {
            return arrayList;
        }

        StringBuffer stringBuffer = new StringBuffer(str);
        add1(stringBuffer,0,arrayList,str);
        return arrayList;
    }

    public void add1(StringBuffer str, int begin, ArrayList<String> arrayList, String orgin){
        int len = str.length();
        if (begin == len) {
            return;
        }
        for (int i = begin;i<len;i++) {
            char temp = str.charAt(begin);
            str.setCharAt(begin,str.charAt(i));
            str.setCharAt(i,temp);
            if (!arrayList.contains(str.toString())) {
                arrayList.add(str.toString());
            }
            add1(str,begin+1,arrayList,orgin);
            str.setCharAt(i,str.charAt(begin));
            str.setCharAt(begin,temp);
        }

    }

    public static void main(String[] args) {
        String s = "abc";
        Problem28 p = new Problem28();
        ArrayList a = p.Permutation1(s);

        StringBuffer ss = new StringBuffer(s);
        StringBuffer sss = new StringBuffer(ss);
        if (ss.equals(sss)) {
            System.out.println(true);
        }
        char temp = ss.charAt(1);
        ss.setCharAt(1,ss.charAt(0));
        ss.setCharAt(0,temp);
        if (s.equals(ss)) {
            System.out.println("true");
        }
        if (ss.equals(sss)) {
            System.out.println(true);
        }
        if (ss.equals(ss)) {
            System.out.printf("true");
        }
    }
}

