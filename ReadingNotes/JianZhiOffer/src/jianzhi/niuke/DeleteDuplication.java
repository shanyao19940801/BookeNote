package jianzhi.niuke;

import jianzhi.Standard.ListNode;

/**
 * Created by shanyao on 2018/7/8.
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p = pHead;
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode p2 = head;
        while(p != null){
            boolean tem = false;
            while(p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
                tem = true;
            }
            if(p.next == null && tem) {
                p2.next = null;
                break;
            }
            if(tem) {
                p2.next = p2.next.next;
            } else {
                p2 = p2.next;
            }
            tem = false;
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        DeleteDuplication d = new DeleteDuplication();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode l = d.deleteDuplication(a1);
        System.out.println(l.val);

    }
}
