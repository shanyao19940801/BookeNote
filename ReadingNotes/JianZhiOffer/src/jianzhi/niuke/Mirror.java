package jianzhi.niuke;

import jianzhi.Standard.TreeNode;

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
}
