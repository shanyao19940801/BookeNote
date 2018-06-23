package jianzhi.chapter03.c04;

import jianzhi.Standard.ListNode;

/**
 * Created by shanyao on 2018/6/22.
 */
public class Problem16 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;
        ListNode p = ReverseList(head);
        System.out.println(p);
    }
    public static ListNode ReverseList(ListNode head) {
        /*List<ListNode> listNodes = new ArrayList<ListNode>();
        while(head.next != null) {
            listNodes.add(head);
            head = head.next;
        }
        head.next = listNodes.get(listNodes.size()-1);
        for(int i = listNodes.size()-1; i >0; i++) {
            listNodes.get(i).next = listNodes.get(i-1);
        }
        */
        if (head == null || head.next == null)
            return head;
        ListNode pHead = new ListNode(head.val);
        while (head.next != null) {
            ListNode pH = new ListNode(head.next.val);
            pH.next = pHead;
            pHead = pH;
            head = head.next;
        }
        return pHead;
    }

    public ListNode ReverseList1(ListNode head) {
        if(head==null)
            return null;
        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while(pNode!=null){
            ListNode pNext = pNode.next;
            if(pNext==null)
                newHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return newHead;
    }
}
