package jianzhi.chapter03.c04;

import jianzhi.Standard.ListNode;
import jianzhi.Util;

/**
 * Created by shanyao on 2018/6/23.
 */
public class Problem15_2 {
    public static boolean judge(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode pHead = head;
        boolean isH = false;
        while (head != null && head.next != null) {
            head = head.next.next;
            pHead = pHead.next;
            if (head == pHead) {
                isH = true;
                break;
            }
        }
        return isH;
    }

    public static void main(String[] args) {
        ListNode head = Util.getListNodes(4);
        ListNode pHead = head;
        while (pHead.next != null){
            pHead = pHead.next;
        }
        pHead.next = head;
        System.out.println(judge(head));
        System.out.println();
    }
}
