package jianzhi.Standard;

/**
 * Created by user on 2018/3/2.
 */
public class PrintBinaryTree {
    public static void print(BinaryTreeNode tree) {
        prePtint(tree);
        inPtint(tree);
    }

    public static void prePtint(BinaryTreeNode tree) {
        if (tree == null)
            return;
        System.out.println(tree.value+",");
        prePtint(tree.left);
        prePtint(tree.right);
    }
    //中序
    public static void inPtint(BinaryTreeNode tree) {
        if (tree == null)
            return;
        inPtint(tree.left);
        System.out.println(tree.value+",");
        inPtint(tree.right);
    }

}
