package jianzhi.niuke;

import jianzhi.Standard.ListNode;

import java.util.HashSet;

/**
 * Created by shanyao on 2018/7/8.
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        HashSet<ListNode> lists = new HashSet<ListNode>();
        ListNode r = null;
        while(pHead != null) {
            if(lists.contains(pHead)) {
                r=pHead;
                break;
            }
            pHead = pHead.next;
        }
        return r;
    }

    /*
    1.定义快慢指针，找到相遇节点；
    2.计算环的长度length；
    3.在定义快慢指针，先让快指针走length步，在让慢指针走。直到两个指针相等时，即为入口节点；
        复杂度为O(n);
    */
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        //找到相遇节点
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        do{
            p2 = p2.next.next;
            p1 = p1.next;
        }while(p2!=null && p2 != p1);
        if(p2 == null) {
            return null;
        }
        int len = 0;
        do {
            len++;
            p2 = p2.next;
        } while(p1 != p2);

        p1 = p2 = pHead;
        for(int i = 0; i < len; i++) {
            p2 = p2.next;
        }
        while(p1!=p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop e = new EntryNodeOfLoop();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a3;
        ListNode re = e.EntryNodeOfLoop(a1);
        System.out.println(re.val);
    }
}
