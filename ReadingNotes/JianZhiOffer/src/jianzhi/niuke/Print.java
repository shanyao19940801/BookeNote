package jianzhi.niuke;

import jianzhi.Standard.TreeNode;
import jianzhi.Util;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shanyao on 2018/7/9.
 */
public class Print {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)
            return list;

        Stack<TreeNode> p1 = new Stack<TreeNode>();
        Stack<TreeNode> p2 = new Stack<TreeNode>();
        p1.push(pRoot);
        while(!p1.isEmpty() || !p2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            boolean isl = true;
            while(!p1.isEmpty()) {
                TreeNode t1 = p1.pop();
                temp.add(t1.val);
                push(t1,isl,p2);
            }
            isl = false;
            if (temp.size() > 0)
                list.add(temp);
            temp = new ArrayList<Integer>();
            while(!p2.isEmpty()) {
                TreeNode t1 = p2.pop();
                temp.add(t1.val);
                push(t1,isl,p1);
            }
            if (temp.size() > 0)
                list.add(temp);
        }
        return list;
    }

    public void push(TreeNode root, boolean isl, Stack<TreeNode> stack) {
        if (isl) {
            if(root.left != null) {
                stack.push(root.left);
            }
            if(root.right != null) {
                stack.push(root.right);
            }
        } else {
            if(root.right != null) {
                stack.push(root.right);
            }
            if(root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static void main(String[] args) {
        Print print = new Print();
        TreeNode root = Util.getTree();
        ArrayList list = print.Print(root);
        System.out.println(list);

    }
}
