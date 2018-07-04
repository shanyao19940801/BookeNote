package jianzhi.chapter05.c03;

import jianzhi.Standard.ListNode;

/**
 * Created by shanyao on 2018/7/4.
 */
public class Problem37 {
    //方法一：先算出两个链表第一个公共节点之前相差节点n个，然后把多个链表前移n个后两个链表一起前移知道相同为止
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
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
    }
}
