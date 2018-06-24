package jianzhi.chapter;


import jianzhi.Standard.BinaryTreeNode;
import jianzhi.Standard.PrintBinaryTree;
import jianzhi.Standard.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by shanyao on 2018/6/11.
 */
public class Solution {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        TreeNode treeNode = new TreeNode(pre[0]);
        int i = 0;
        for (;i<in.length;i++) {
            if (in[i] == pre[0]) {

                break;
            }
        }

            treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));

            treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
        return treeNode;
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,3,5,6};
        int [] in =  {4,2,1,5,3,6};
//        int [] c = Arrays.copyOfRange(in,0,2);
        TreeNode treeNode = reConstructBinaryTree(pre,in);
        TreeNode treeNode1= solution2(pre,in);
//        inPtint(treeNode);
        inPtint(treeNode1);
    }

    public static void inPtint(TreeNode tree) {
        if (tree == null)
            return;
        System.out.println(tree.val+",");
        inPtint(tree.left);
        inPtint(tree.right);
    }

    public static TreeNode solution2(int [] pre,int [] in) {
        if(pre.length == 0||in.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++){
            if(pre[0] == in[i]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1,in.length));
            }
        }
        return node;
    }

}
