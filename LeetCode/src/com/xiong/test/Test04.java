package com.sangfor.security.test;

import java.util.Set;
import javax.swing.tree.TreeNode;

/**
 * 二叉树操作
 * @version 2.0.0
 * @author 赵小雄59782
 * @date 2020/11/30 17:11
 */
public class Test04 {

    private static class BinaryTree {
        int val;
        BinaryTree left;
        BinaryTree right;
    }

    /*** 
     * 得到一个二叉树的镜像二叉树
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:23
     * @param treeNode 入参
     * @return 
     */
    public void mirror(BinaryTree treeNode) {
        if (null != treeNode) {
            //节点的交换
            BinaryTree node = treeNode.left;
            treeNode.right = treeNode.left;
            treeNode.left = node;
        }
        mirror(treeNode.left);
        mirror(treeNode.right);
    }

    /*** 
     * 二叉树的最大深度
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:25
     * @param node 
     * @return 
     */
    public int maxDepth(BinaryTree node) {
        if (null == node) {
            return 0;
        }
        int left_depth = maxDepth(node.left);
        int right_depth = maxDepth(node.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    /*** 
     * 二叉树的最小深度
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:25
     * @param node todo {这里必须添加参数注释}
     * @return 
     */
    public static int minDepth(BinaryTree node) {
        if (null == node) {
            return 0;
        }
        if (node.left == null) {
            return minDepth(node.left) + 1;
        }
        if (node.right == null) {
            return minDepth(node.right) + 1;
        }

        int left_depth = minDepth(node.left);
        int right_depth = minDepth(node.right);

        return Math.min(left_depth, right_depth);
    }

    /*** 
     * 判断2个二叉树是否完全相同
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:26
     * @param node1 入参1
     * @param node2 入参2
     * @return 
     */
    public boolean checkTree(BinaryTree node1, BinaryTree node2) {
        if (null == node1 && null == node2) {
            return true;
        }
        if (null == node1 || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return checkTree(node1.left, node2.left) && checkTree(node1.right, node2.right);
        }
        return false;
    }

    /*** 
     *
     *
     * @author 赵小雄59782
     * @date 2020/11/30 20:26
     * @param args todo {这里必须添加参数注释}
     * @return 
     */



    public static void main(String[] args) {

        BinaryTree node = new BinaryTree();
        node.val = 10;

        BinaryTree node1 = new BinaryTree();

    }

}
