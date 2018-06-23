package jianzhi.chapter03.c04;

import jianzhi.Standard.ListNode;
import jianzhi.Util;

/**
 * Created by shanyao on 2018/6/23.
 */
public class Problem15_1 {
    public static ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pHead = head;

        while (pHead != null && pHead.next != null) {
            pHead = pHead.next.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = Util.getListNodes(6);
        head = findMiddle(head);
        System.out.println();
    }
}
