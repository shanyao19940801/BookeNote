package jianzhi.chapter04.c04;

import jianzhi.capter02.c02.Main;
import jianzhi.niuke.Permutation;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by shanyao on 2018/7/1.
 */
public class Problem28_01 {

    ArrayList list = new ArrayList();
    ArrayList<String> list1 = new ArrayList();
    TreeSet<String> treeSet = new TreeSet<>();
    public void Permutation(int [] que, int begin) {
        if (begin == 8)
            return;
        if (jeduge(que)) {
            if (!list.contains(que)) {
                print(que);
                list.add(que);
            }
        }
        for (int i = begin; i < 8; i++) {
            int temp = que[i];
            que[i] = que[begin];
            que[begin] = temp;
//            print(que);
            Permutation(que.clone(),begin+1);
            que[begin] = que[i];
            que[i] = temp;
        }
    }

    public boolean jeduge(int [] queue) {
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (Math.abs(i-j) == Math.abs(queue[i]-queue[j]))
                    return false;
            }
        }
//        System.out.println("借");
//        print(queue);
        return true;
    }
    public static void main(String[] args) {
//        int [] a = {0,1,2,3,4,5,6,7};
        Problem28_01 p = new Problem28_01();
//        p.Permutation(a,0);
//        System.out.println(p.list.size());
        String s = "01234567";
        p.Permutation1(s,0,new StringBuffer(s));
        System.out.println(p.treeSet);
    }

    public void print(int [] a) {
        for (int i = 0; i < 8; i++)
            System.out.print(a[i]);
        System.out.println();
    }

    public void Permutation1(String que, int begin,StringBuffer str) {
        int len = que.length();
        if (begin == 8)
            return;
        if (jeduge1(str)) {
            if (!list1.contains(str.toString())) {
//                print(que);
                list1.add(str.toString());
            }
        }

        for (int i = begin;i<len;i++) {
            char temp = str.charAt(begin);
            str.setCharAt(begin,str.charAt(i));
            str.setCharAt(i,temp);
            if (jeduge1(str)) {
                treeSet.add(str.toString());
            }
            Permutation1(que,begin+1,str);
            str.setCharAt(i,str.charAt(begin));
            str.setCharAt(begin,temp);
        }
    }

    private boolean jeduge1(StringBuffer curr) {
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (Math.abs(i-j) == Math.abs(curr.charAt(i)-curr.charAt(j)))
                    return false;
            }
        }
//        System.out.println("借");
//        print(queue);
        return true;
    }
}
