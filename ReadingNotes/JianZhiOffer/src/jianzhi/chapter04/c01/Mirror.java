package jianzhi.chapter04.c01;

import jianzhi.Standard.TreeNode;
import jianzhi.Util;

/**
 * Created by shanyao on 2018/6/24.
 */
public class Mirror {
    public static TreeNode Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        TreeNode t = Mirror(root);
        System.out.println(t);

    }
}
