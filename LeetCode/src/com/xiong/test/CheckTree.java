package com.xiong.test;

import java.util.ArrayList;
import java.util.List;

public class CheckTree {

	/**
	 * 给定一个正整数，返回所有符合二叉搜索树的个数
	 * 实质是亚特兰数
	 * @param n
	 * @return
	 */
	
	public static int numTrees(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
        for(int i = 2 ; i <= n ; i ++){  
        	for(int j = 1; j <= i; j++) {
        		arr[i] += arr[i-j] * arr[j-1];
        	}
        }  
        return arr[n];
	}
	
	 /***
	  * 返回同深度的集合
	  * @param root
	  * @return
	  */
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 List<List<Integer>> reslist = new ArrayList<List<Integer>>();
		 List<Integer> list = new ArrayList<>();
		 if(root != null) levelOrder(list, root);
		 reslist.add(list);
		 return reslist;
	 }
	 
	 public static void levelOrder(List<Integer> list, TreeNode root) {
		if (root != null) list.add(root.val);
		levelOrder(list, root.left);
		levelOrder(list, root.right);
	}
	 
	/***
	 * 反转一个二叉树，使得成为镜像的
	 * @param root
	 */
	public static TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	
	/***
	 * 中序遍历
	 * @param root
	 * @return
	 */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) inorderTraversalCheck(list, root);
        return list;
    }
    
    public static void inorderTraversalCheck(List<Integer> list, TreeNode root) {
    	if (root.left != null) inorderTraversalCheck(list, root.left);
        list.add(root.val);
        if (root.right != null) inorderTraversalCheck(list, root.right);
    }
	
	/***
	 * 后序遍历，返回数字
	 * @param root
	 * @return
	 */
	public static List<Integer> postOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
        if (root != null) PostaddOrder(list,root);
        return list;
	}
	
	public static void PostaddOrder(List<Integer> list, TreeNode root) {
		if (root.left != null) PostaddOrder(list, root.left);
		if (root.right != null) PostaddOrder(list, root.right);
		if (root != null) list.add(root.val);
	}
	
	/***
	 * 前序遍历二叉树
	 * @param root
	 * @return
	 */
	public static List<Integer> preOrder(TreeNode root) {
		List<Integer> list = new ArrayList<>();
        if (root != null) PreaddOrder(list,root);
        return list;
	}
	
	public static void PreaddOrder(List<Integer> list, TreeNode root) {
		if (root != null) list.add(root.val);
		if (root.left != null) PreaddOrder(list, root.left);
		if (root.right != null) PreaddOrder(list, root.right);
	}
	
	/***
	 * Sum Root to Leaf Numbers
	 * @param root
	 * @return
	 */
	public static int preSumRoot(TreeNode root) {
		return preSum(0, root);
	}
	
	public static int preSum(int sum, TreeNode root) {
		if(root == null) return 0;
		sum = sum*10 + root.val;
		if(root.left == null && root.right == null) return sum;
		return preSum(sum, root.left) + preSum(sum, root.right);
	}
	
	/***
	 * 判断二叉树是否是镜像对称
	 * @param root
	 * @return
	 */
	public static boolean isSym(TreeNode root) {
		if(root == null) return true;
		return ischeckSym(root.left,root.right);
	}
	
	public static boolean ischeckSym(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		if (left.val == right.val)  return ischeckSym(left.left,right.right) && ischeckSym(left.right, right.left);
	    return false;
	}
	
	
	/***
	 * 判断是否是平衡二叉树
	 * @param root
	 * @return
	 */
	public static boolean isBalance(TreeNode root) {
		if (root == null) return true;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (left - right > 1 || left - right < -1) return false;
		return isBalance(root.left) && isBalance(root.right);
	}
	/**
	 * 判断一棵树是否是二叉搜索树
	 * @param root
	 * @return
	 */
	
	public static boolean isBST(TreeNode root) {
		return isBSTpre(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public static boolean isBSTpre(TreeNode root, long min, long max) {
		if(root == null) return true;
		if (min < root.val && max > root.val) 
			return isBSTpre(root.left, min, root.val) && isBSTpre(root.right, root.val, max);
        else  return false;
	}
	
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
