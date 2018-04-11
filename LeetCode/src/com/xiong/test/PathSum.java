package com.xiong.test;

public class PathSum {
	
	//遍历二叉树，判断是否有一条路径使得和为目标值
	
	public static boolean hasPathSum(TreeNode node,int target) {
		if (node == null) return false;
		if (node.left == null && node.right == null && node.val == target) return true;
		return hasPathSum(node.left, target-node.val) || hasPathSum(node.right, target-node.val);
 	}

}
