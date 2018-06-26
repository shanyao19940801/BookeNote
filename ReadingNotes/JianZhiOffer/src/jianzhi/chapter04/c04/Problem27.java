package jianzhi.chapter04.c04;

import jianzhi.Standard.TreeNode;
import jianzhi.Util;

/**
 * Created by shanyao on 2018/6/26.
 */
public class Problem27 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        TreeNode lists = null;
        lists =  buildList(pRootOfTree,lists);
        while (lists.left != null) {
            lists = lists.left;
        }
        return lists;
    }

    public TreeNode buildList(TreeNode root,TreeNode lists) {
        if (root == null)
            return null;
        TreeNode cu = root;
        if (cu.left != null) {
            lists = buildList(cu.left, lists);
        }
        cu.left = lists;
        if (lists != null) {
            lists.right = cu;
        }
        lists = cu;
        if (cu.right != null) {
            lists = buildList(cu.right,lists);
        }
        return lists;
    }

    public static void main(String[] args) {

        TreeNode treeNode = Util.getSouSuoTree();

        Problem27 p = new Problem27();

        p.teset(new TreeNode(10),1);
        TreeNode lists = p.Convert(treeNode);
        System.out.println(lists);

    }

    public void teset(TreeNode treeNode,int i){
        if (i == 3)
            return;
        treeNode.left = new TreeNode(i);
        teset(treeNode,i+1);
        treeNode.right = new TreeNode(i);
    }


}
