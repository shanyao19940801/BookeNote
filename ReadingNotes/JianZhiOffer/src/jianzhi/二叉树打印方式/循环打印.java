package jianzhi.二叉树打印方式;

import jianzhi.Standard.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shanyao on 2018/6/24.
 */
public class 循环打印 {
    //中序遍历
    public List printZhong(TreeNode root) {
        List list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null){
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.right);
            }
        }
        return list;
    }
}
