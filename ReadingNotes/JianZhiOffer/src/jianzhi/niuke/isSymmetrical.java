package jianzhi.niuke;

import jianzhi.Standard.TreeNode;

/**
 * Created by shanyao on 2018/7/9.
 */
public class isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)
            return true;

        return isT(pRoot.right,pRoot.left);

    }

    boolean isT(TreeNode r1,TreeNode r2) {
        if(r1 == null && r2 == null)
            return true;
        if(r1 == null || r2 == null) {
            return false;
        }
        if(r1.val != r2.val) {
            return false;
        }
        return (isT(r1.left,r2.right)&&isT(r1.right,r2.left));

    }
}
