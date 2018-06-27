package jianzhi.chapter04.c03;

import jianzhi.Standard.TreeNode;
import jianzhi.Util;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by shanyao on 2018/6/25.
 */
public class Problem25 {
    //方法二
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> lu = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if(root == null)
            return lists;
        target -= root.val;
        lu.add(root.val);
        if(root.left == null && root.right == null) {
            if(target == 0)
                lists.add(new ArrayList(lu));
        }
        if(root.left !=null) {
            FindPath(root.left,target);
        }
        if(root.right != null) {
            FindPath(root.right,target);
        }
        lu.remove(lu.size()-1);
        target+=root.val;
        return lists;
    }

    //方法一
    /*public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return new ArrayList();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> lu = new ArrayList<>();
        lu.add1(root.val);
        getAllList(root,target,root.val,lu,lists);
        return lists;
    }

    public void getAllList(TreeNode root,int target,int sum,ArrayList<Integer> lu,
                           ArrayList<ArrayList<Integer>> lists) {
        if(root.left == null && root.right == null) {
            if(sum == target)
                lists.add1(lu);
            return;
        }

        if(root.left != null) {
            ArrayList<Integer> l = new ArrayList(lu);
            l.add1(root.left.val);
            getAllList(root.left,target,sum+root.left.val,l,lists);
        }
        if(root.right != null) {
            ArrayList<Integer> l = new ArrayList(lu);
            l.add1(root.right.val);
            getAllList(root.right,target,sum+root.right.val,l,lists);
        }
    }*/
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
//        list.remove()
    }
}
