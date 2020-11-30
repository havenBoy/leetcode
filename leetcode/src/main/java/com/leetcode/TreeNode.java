package com.leetcode;

import java.util.Stack;

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
    
    /***
     * 非递归实现
     * @param node
     */
    public static void preNode1(TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();
    	if (node != null) {
			stack.push(node);
		}
    	while(stack.size() != 0) {
            TreeNode p = stack.pop();
            System.out.println(p.val);
            if (node.left != null) stack.push(p.left);
            if (node.right != null) stack.push(p.right);
    	}
	}
    
    
    
    
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
