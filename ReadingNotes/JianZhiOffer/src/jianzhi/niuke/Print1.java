package jianzhi.niuke;

import jianzhi.Standard.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by shanyao on 2018/7/9.
 */
public class Print1 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> s1 = new LinkedList();
        LinkedList<TreeNode> s2 = new LinkedList();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        s1.add(pRoot);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode t = s1.pop();
                list.add(t.val);
                push(t,s2);
            }
            if (list.size() > 0)
                lists.add(list);
            list = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode t = s2.pop();
                list.add(t.val);
                push(t,s1);
            }
            if (list.size() > 0)
                lists.add(list);
        }
        return lists;

    }

    public void push(TreeNode t, LinkedList<TreeNode> s2){
        if (t.left != null) {
            s2.add(t.left);
        }
        if (t.right != null) {
            s2.add(t.right);
        }
    }
}
