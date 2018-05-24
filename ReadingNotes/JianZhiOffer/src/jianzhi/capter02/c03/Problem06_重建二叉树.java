package jianzhi.capter02.c03;

import jianzhi.Standard.BinaryTreeNode;
import jianzhi.Standard.PrintBinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018/3/1.
 * 重建二叉树
 * 根据前序和中序序列（不含有重复的数字），构建一棵二叉树
 * 思路:前序遍历数组中第一个数总是根节点，而该节点在中序遍历中
 * 根据前序的根节点遍历中序分别添加左右子节点
 */
public class Problem06_重建二叉树 {


    /**
     *
     * @param pre 前序数组
     * @param in  中序数组
     * @param ps 前序开始
     * @param pe    前序结束
     * @param is 中序开始
     * @param ie 中序结束
     * @param point  记录中序位置
     */
    public static BinaryTreeNode rebuild(int[] pre, int[] in, int ps,int pe,int is, int ie, Map<Integer, Integer> point) {

        if (ps > pe) {//前序数组结束
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(pre[ps]);//根节点
        int i = 0;//根节点在中序遍历数组中的位置
        try {
            i = point.get(pre[ps]);
        } catch (Exception e) {
            return null;
        }
        //左儿子
        node.left = rebuild(pre,in,ps+1,ps+i-is,is,i-1,point);
        //友儿子
        node.right = rebuild(pre,in,ps+i-is+1,pe,i+1,ie,point);
        return node;
    }

    public static BinaryTreeNode build(int[] pre, int[] in) {
        if (pre == null || in == null)
            return null;
        BinaryTreeNode treeNode = new BinaryTreeNode();
        Map<Integer,Integer> point = new HashMap<Integer,Integer>();
        for (int i = 0; i < in.length; i++) {
            point.put(in[i],i);
        }
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                treeNode = rebuild(pre,in,0,pre.length-1,0,in.length-1,point);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        BinaryTreeNode treeNode = test01();
        System.out.println(treeNode);
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    private static BinaryTreeNode test01() {
        BinaryTreeNode treeNode = new BinaryTreeNode();

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};//前序
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};//中序
        treeNode = build(pre, in);
        return treeNode;
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] pre = {1, 2, 3, 4, 5};
        int[] in = {5, 4, 3, 2, 1};
        BinaryTreeNode root = build(pre, in);
        PrintBinaryTree.print(root);
    }

    // 所有结点都没有左子结点  
    //            1  
    //             \  
    //              2  
    //               \  
    //                3  
    //                 \  
    //                  4  
    //                   \  
    //                    5  
    private static void test3() {
        int[] pre = {1, 2, 3, 4, 5};
        int[] in = {1, 2, 3, 4, 5};
        BinaryTreeNode root = build(pre, in);
        PrintBinaryTree.print(root);
    }
    // 树中只有一个结点  
    private static void test4() {
        int[] pre = {1};
        int[] in = {1};
        BinaryTreeNode root = build(pre, in);
        PrintBinaryTree.print(root);
    }
    // 完全二叉树  
    //              1  
    //           /     \  
    //          2       3  
    //         / \     / \  
    //        4   5   6   7  
    private static void test5() {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode root = build(pre, in);
        PrintBinaryTree.print(root);
    }
    // 输入空指针  
    private static void test6() {
        build(null, null);
    }
    // 输入的两个序列不匹配  
    private static void test7() {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 8, 1, 6, 3, 7};
        BinaryTreeNode root = build(pre, in);
        PrintBinaryTree.print(root);
    }
}
