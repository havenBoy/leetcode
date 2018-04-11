package com.xiong.test;

/**
 * 二叉树的定义
 * @author xiaoxiong
 *
 */
public class TreeNode {
	
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    //前序遍历
    public static void preNode(TreeNode node) {
		if (node != null) {
			System.out.println(node.val);
			preNode(node.left);
			preNode(node.right);
		}
	}
    //中序遍历
    public static void midNode(TreeNode node) {
		if (node != null) {
			midNode(node.left);
			System.out.println(node.val);
			midNode(node.right);
		}
	}
    //后续遍历
    public static void lastNode(TreeNode node) {
		if (node != null) {
			lastNode(node.left);
			lastNode(node.right);
			System.out.println(node.val);
		}
	}
}
