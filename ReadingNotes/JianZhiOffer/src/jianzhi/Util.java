package jianzhi;

import jianzhi.Standard.ListNode;
import jianzhi.Standard.TreeNode;

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

    public static TreeNode getTree(){
        TreeNode root = new TreeNode(8);
        TreeNode root8 = new TreeNode(8);
        root.left = root8;
        TreeNode root9 = new TreeNode(9);
        root8.left = root9;
        TreeNode root2 = new TreeNode(2);
        root8.right = root2;
        TreeNode root4 = new TreeNode(4);
        root2.left = root4;
        TreeNode root7 = new TreeNode(7);
        root2.right = root7;
        TreeNode root71 = new TreeNode(7);
        root.right = root71;
        return root;
    }
}
