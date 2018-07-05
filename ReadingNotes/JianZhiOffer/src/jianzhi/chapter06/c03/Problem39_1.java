package jianzhi.chapter06.c03;

import jianzhi.Standard.TreeNode;

/**
 * Created by shanyao on 2018/7/5.
 * 判断是否是平衡二叉树
 */
public class Problem39_1 {
    //解法一：判断每个左右节点深度是否相差超过一
    //这种解法会有很多重复遍历
    public boolean judgeE(TreeNode root) {
        if (root == null)
            return true;
        else {
            if (Math.abs(TreeDepth(root.left)-TreeDepth(root.right)) > 1)
                return false;
            else {
                return judgeE(root.left) && judgeE(root.right);
            }
        }
    }

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int ld = TreeDepth(root.left);
        int lr = TreeDepth(root.right);
        return ld > lr ? (ld + 1) : (lr + 1);
    }

    //解法二：每个节点只遍历一次，利用后续遍历遍历每个节点同时记录节点深度
    public boolean isBelace(TreeNode root, int[] dep) {
        if (root == null) {
            dep[0] = 0;
            return true;
        }
        int left[] = new int[1],right[] = new int[1];
        if (isBelace(root.left,left) && isBelace(root.right,right)) {
            if (Math.abs(left[0]-right[0]) <= 1) {
                dep[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return isBelace(root,new int[1]);
    }
}
