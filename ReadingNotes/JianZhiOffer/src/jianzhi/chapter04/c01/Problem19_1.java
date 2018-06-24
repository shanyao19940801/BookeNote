package jianzhi.chapter04.c01;

import jianzhi.Standard.TreeNode;
import jianzhi.Util;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shanyao on 2018/6/24.
 */
public class Problem19_1 {
    public static void Mirror(TreeNode root) {
        if (root == null)
            return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left != null || curr.right != null){
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
            }
            if (curr.right != null){
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = Util.getTree();
        Mirror(root);
    }
}
