package jianzhi.chapter03.c04;

import jianzhi.Standard.TreeNode;

/**
 * Created by shanyao on 2018/6/23.
 */
public class Problem18 {
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        /*if(root2 == null)
            return false;
        boolean re = false;
        if(root1.val == root2.val) {
            re = judgeSon(root1,root2);
        }
        if (root1.left != null && !re) {
            re =  HasSubtree(root1.left,root2);
        }
        if (root1.right != null && !re) {
            re =  HasSubtree(root1.right,root2);
        }
        return re;*/

        //简洁的写法
        boolean re = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                re = judgeSon(root1,root2);
            }
            if (!re) {
                re = HasSubtree(root1.left, root2);
            }
            if (!re) {
                re = HasSubtree(root1.right,root2);
            }
        }
        return re;
    }

    public static boolean judgeSon(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val == root2.val) {
            return (judgeSon(root1.left,root2.left)&&(judgeSon(root1.right,root2.right)));
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode root8 = new TreeNode(8);
        root.left = root8;
        TreeNode root9 = new TreeNode(9);
        root8.left = root9;
        TreeNode root2 = new TreeNode(2);
        root8.right = root2;
        TreeNode root4 = new TreeNode(4);
        root2.left = root4;
        TreeNode root7 = new TreeNode(7);
        root2.right = root7;
        TreeNode root71 = new TreeNode(7);
        root.right = root71;


        TreeNode rootW = new TreeNode(8);
        TreeNode rootW9 = new TreeNode(9);
        TreeNode rootW2 = new TreeNode(2);
        rootW.left = rootW9;
        rootW.right = rootW2;

        System.out.println(HasSubtree(root, rootW));



    }
}
