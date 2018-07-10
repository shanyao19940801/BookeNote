package jianzhi.niuke;

import jianzhi.Standard.TreeNode;

import java.util.ArrayList;

/**
 * Created by shanyao on 2018/7/9.
 */
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        getList(pRoot,list);
        if(k <= list.size()) {
            return list.get(k-1);
        }
        return null;
    }

    public void getList(TreeNode pRoot, ArrayList<TreeNode> list) {
        if(pRoot == null)
            return;
        getList(pRoot.left,list);
        list.add(pRoot);
        getList(pRoot.right,list);
    }
}
