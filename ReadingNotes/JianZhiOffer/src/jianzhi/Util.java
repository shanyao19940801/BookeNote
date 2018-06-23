package jianzhi;

import jianzhi.Standard.ListNode;

/**
 * Created by shanyao on 2018/6/23.
 */
public class Util {
    public static ListNode getListNodes(int n){
        if (n <= 0)
            return null;
        ListNode head = new ListNode(1);
        ListNode pHead = head;
        for (int i = 2; i <= n; i++) {
            pHead.next = new ListNode(i);
            pHead = pHead.next;
        }
       /* ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;*/
        return head;
    }
}
