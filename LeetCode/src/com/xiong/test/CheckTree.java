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

}
