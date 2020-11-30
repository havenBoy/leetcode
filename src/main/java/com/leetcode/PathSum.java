package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	
	/**
	 * 遍历二叉树，判断是否有一条路径使得和为目标值(DFS)
	 * @param node
	 * @param target
	 * @return
	 */
	public static boolean hasPathSum(com.xiong.test.TreeNode node, int target) {
		if (node == null) return false;
		if (node.left == null && node.right == null && node.val == target) return true;
		return hasPathSum(node.left, target-node.val) || hasPathSum(node.right, target-node.val);
 	}
	
	/**
	 * 遍历二叉树，返回目标值路径的集合(DFS)
	 * @param root
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> pathSum(com.xiong.test.TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> listSub = new ArrayList<Integer>();
		pathSumSub(list, listSub, root, sum);
		return list;
	}
	/**
	 * 迭代方法
	 * @param list
	 * @param listSub
	 * @param root
	 * @param sum
	 */
	public static void pathSumSub(List<List<Integer>> list, List<Integer> listSub, com.xiong.test.TreeNode root, int sum) {
		if(root == null) return;
		listSub.add(root.val);
		if(root.left == null && root.right == null && root.val == sum) {
			list.add(new ArrayList<>(listSub));
			listSub.remove(listSub.size()-1);
			return;
		} else {
			pathSumSub(list, listSub, root.left, sum-root.val);
			pathSumSub(list, listSub, root.right, sum-root.val);
		}
		listSub.remove(listSub.size()-1);
	}

}
