package jianzhi.chapter03.c04;

import jianzhi.Standard.ListNode;

/**
 * Created by shanyao on 2018/6/23.
 */
public class Problem17 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head ;
        if (list1.val >= list2.val) {
            head = list2;
            Merge(list1, list2.next);
        } else {
            head = list1;
            Merge(list1.next, list2);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = list1;
        ListNode list3 = new ListNode(2);
        list1.next = list3;

        if (list1 == list2) {
            System.out.println("true");
        }
    }
}
