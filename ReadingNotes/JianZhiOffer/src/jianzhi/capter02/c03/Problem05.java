package jianzhi.capter02.c03;

import jianzhi.Standard.ListNode;

import java.util.Stack;

/**
 * Created by user on 2018/3/1.
 * 从尾到头打印链表
 */
public class Problem05 {
    //利用递归打印
    public void digui(ListNode head) {
        if (head == null) {
            return;
        }
        digui(head.next);
        System.out.println(head.val);
    }
    //利用栈
    public void printListInverselyUsingStack(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Problem05 p = new Problem05();
        p.printListInverselyUsingStack(head);
        p.digui(head);
    }
}
