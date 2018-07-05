package jianzhi.chapter06.c03;

import jianzhi.Standard.TreeNode;

/**
 * Created by shanyao on 2018/7/5.
 */
public class Problem39 {
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int ld = TreeDepth(root.left);
        int lr = TreeDepth(root.right);
        return ld > lr ? (ld + 1) : (lr + 1);
    }
}
