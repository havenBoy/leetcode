package com.xiong.test;

public class CheckTree {
	
	/**
	 * 判断2个二叉树是否相同    递归的思想
	 */
	public static boolean checkTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val == q.val) {
			return checkTree(p.left, q.left) && checkTree(p.right, q.right);
		}
		return false;
	}
	/***
	 * 二叉树的最大深度
	 * @param node
	 * @return
	 */
	public static int maxDepth(TreeNode node) {
		if (node == null) return 0;
		int left = maxDepth(node.left) + 1;
		int right = maxDepth(node.right) + 1;
		return left > right ? left : right ;
	}
	/***
	 * 返回二叉树的最小深度
	 * @param node
	 * @return
	 */
	public static int minDepth(TreeNode node) {
		if (node == null) return 0;
		if (node.left == null)  return minDepth(node.right) + 1;
		if (node.right == null) return minDepth(node.left) + 1;
		int left = minDepth(node.left) + 1;
		int right = minDepth(node.right) + 1;
		return left > right ? right : left ;
	}

}
