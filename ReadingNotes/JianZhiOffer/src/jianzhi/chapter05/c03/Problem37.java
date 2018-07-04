package jianzhi.chapter05.c03;

import jianzhi.Standard.ListNode;

import java.util.Stack;

/**
 * Created by shanyao on 2018/7/4.
 */
public class Problem37 {
    //方法二：利用两个栈
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while(pHead1 != null) {
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2 != null) {
            s2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode r = null;
        while(!s1.isEmpty() && !s2.isEmpty() && (s1.peek()) == s2.peek()) {
            s1.pop();
            r = s2.pop();
        }
        return r;
    }
    //方法一：先算出两个链表第一个公共节点之前相差节点n个，然后把多个链表前移n个后两个链表一起前移知道相同为止
    /*public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //方法一
        if(pHead1 == null || pHead2 == null)
            return null;
        int n1 = 0;
        int n2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != null) {
            n1++;
            p1 = p1.next;
        }

        while(p2 != null) {
            n2++;
            p2 = p2.next;
        }
        if(n1 > n2) {
            while(n1 != n2) {
                pHead1 = pHead1.next;
                n1--;
            }
        } else {
            while(n1!=n2) {
                pHead2 = pHead2.next;
                n2--;
            }
        }
        while(pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }*/


}
