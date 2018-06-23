package jianzhi.chapter03.c04;

import jianzhi.Standard.ListNode;

/**
 * Created by shanyao on 2018/6/23.
 */
public class Problem15 {
    public static ListNode find(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode pHead = head;
        int i = 0;
        while (head != null) {
            head = head.next;
            if (i++ >= k) {
                pHead = pHead.next;
            }
        }
        return i < k ? null : pHead;

    }
    public static void main(String[] args) {

    }
}
