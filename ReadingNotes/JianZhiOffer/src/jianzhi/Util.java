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

    public static TreeNode getSouSuoTree() {
        TreeNode root4 = new TreeNode(4);
        TreeNode root6 = new TreeNode(6);
        root6.left = root4;

        TreeNode root8 = new TreeNode(8);
        root6.right = root8;
        TreeNode root10 = new TreeNode(10);
        root10.left = root6;
        TreeNode root14 = new TreeNode(14);
        root10.right = root14;
        TreeNode root12 = new TreeNode(12);
        root14.left = root12;
        TreeNode root16 = new TreeNode(16);
        root14.right = root16;
        return root10;
    }
}
