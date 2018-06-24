package jianzhi.niuke;

import jianzhi.Standard.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shanyao on 2018/6/24.
 */
public class PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //方法二：使用队列
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return result;
        //方法一使用链表
        /*ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        for (int i = 0; i < treeNodes.size();i++) {
            result.add(treeNodes.get(i).val);
            if (treeNodes.get(i).left != null) {
                treeNodes.add(treeNodes.get(i).left);
            }
            if (treeNodes.get(i).right != null) {
                treeNodes.add(treeNodes.get(i).right);
            }
        }
        return result;*/
    }
}
