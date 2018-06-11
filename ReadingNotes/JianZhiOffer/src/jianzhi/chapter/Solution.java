package jianzhi.chapter;


import jianzhi.Standard.BinaryTreeNode;
import jianzhi.Standard.PrintBinaryTree;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by shanyao on 2018/6/11.
 */
public class Solution {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode treeNode = new TreeNode(pre[0]);
        int i = 0;
        for (;i<in.length;i++) {
            if (in[i] == pre[0]) {
                break;
            }
        }
        if (i+1 == in.length || i == 0) {
            treeNode.left = null;
        } else {
            treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
        }
        if (i == 0) {
            treeNode.right =null;
        } else {
            treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
        }
        return treeNode;
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,3,5,6};
        int [] in =  {4,2,1,5,3,6};
        int [] c = Arrays.copyOfRange(in,0,2);
        TreeNode treeNode = reConstructBinaryTree(pre,in);
        inPtint(treeNode);
    }

    public static void inPtint(TreeNode tree) {
        if (tree == null)
            return;
        inPtint(tree.left);
        System.out.println(tree.val+",");
        inPtint(tree.right);
    }

}
