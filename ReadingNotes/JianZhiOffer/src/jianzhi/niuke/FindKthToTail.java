package jianzhi.niuke;

import jianzhi.Standard.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanyao on 2018/6/20.
 */
public class FindKthToTail {
    /**
     * 解法一，空间占用较大，时间少，遍历一次
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode head, int k) {

        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        if (listNodes.size() == 0 || listNodes.size() < k || k == 0)
            return null;
        return listNodes.get(listNodes.size() - k);
    }

    /**
     * 解法二，时间多空间少
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k==0)
            return null;
        int cout = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            cout++;
        }

        if (cout < k)
            return null;
        for (int i = 0; i < cout - k; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode FindKthToTail3(ListNode head, int k) {
        ListNode pHead = head;
        int q = 0;
        while (head != null) {
            if (q++ >= k)
                pHead = pHead.next;
            head = head.next;
        }
        return q < k ? null : pHead;
    }

    public static void main(String[] args) {
        int i= 3;
        int j = 2;
        while (i-->=0) {
//            System.out.println(j);
            j++;
        }
        int m= 0;
        for (;m< 3;m++) {
            System.out.println(m);
        }
        System.out.println(m);
//        System.out.println(j);
    }
}
