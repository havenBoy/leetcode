package com.leetcode.old;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CheckTree {
//
//	/**
//	 * 给定一个正整数，返回所有符合二叉搜索树的个数
//	 * 实质是亚特兰数
//	 * @param n
//	 * @return
//	 */
//	public static int numTrees(int n) {
//		int[] arr = new int[n+1];
//		arr[0] = 1;
//		arr[1] = 1;
//        for(int i = 2 ; i <= n ; i ++){
//        	for(int j = 1; j <= i; j++) {
//        		arr[i] += arr[i-j] * arr[j-1];
//        	}
//        }
//        return arr[n];
//	}
//	/**
//	 * 从一个有序的数组构建一个搜索二叉树
//	 * 递归的方式利用二分法获取排序后中间的数值
//	 * @param nums
//	 * @return
//	 */
//	public static com.xiong.test.TreeNode sortedArrayToBST(int[] nums) {
//		return createTreeNode(nums, 0, nums.length-1);
//	}
//
//	public static com.xiong.test.TreeNode createTreeNode(int nums[], int low, int high) {
//		if(low > high) return null;
//		int mid = (low + high)/2;
//		com.xiong.test.TreeNode root = new com.xiong.test.TreeNode(nums[mid]);
//		root.left = createTreeNode(nums, low, mid-1);
//		root.right = createTreeNode(nums, mid+1, high);
//		return root;
//	}
//
//	/***
//	  * 返回螺旋遍历树的集合
//	  * @param root
//	  * @return
//	  */
//	 public List<List<Integer>> LevelOrderUp(com.xiong.test.TreeNode root) {
//		 Stack<List<Integer>> stack = new Stack<List<Integer>>();
//		 List<List<Integer>> list = new ArrayList<List<Integer>>();
//		 UpHelper(stack, root, 0);
//		 while(!stack.isEmpty()) {
//			 list.add(stack.pop());
//		 }
//		 return list;
//	 }
//
//	 public static void UpHelper(Stack<List<Integer>> list, com.xiong.test.TreeNode root, int height) {
//		if(root == null) return;
//		if(height >= list.size()) list.add(new LinkedList<Integer>());
//		list.get(height).add(root.val);
//		UpHelper(list, root.left, height+1);
//		UpHelper(list, root.right, height+1);
//	 }
//
//	/***
//	  * 返回螺旋遍历树的集合
//	  * @param root
//	  * @return
//	  */
//	 public List<List<Integer>> zigzagLevelOrder(com.xiong.test.TreeNode root) {
//		 List<List<Integer>> reslist = new ArrayList<List<Integer>>();
//		 ZigzagHelper(reslist, root, 0);
//		 return reslist;
//	 }
//
//	 public static void ZigzagHelper(List<List<Integer>> list, com.xiong.test.TreeNode root, int height) {
//		if(root == null) return;
//		if(height >= list.size()) list.add(new LinkedList<Integer>());
//		list.get(height).add(root.val);
//		if(height % 2 == 1) {
//			ZigzagHelper(list, root.left, height+1);
//			ZigzagHelper(list, root.right, height+1);
//		} else {
//			ZigzagHelper(list, root.right, height+1);
//			ZigzagHelper(list, root.left, height+1);
//		}
//	 }
//
//	 /***
//	  * 返回同深度的集合
//	  * @param root
//	  * @return
//	  */
//	 public List<List<Integer>> levelOrderBottom(com.xiong.test.TreeNode root) {
//		 List<List<Integer>> reslist = new ArrayList<List<Integer>>();
//		 LevelHelper(reslist, root, 0);
//		 return reslist;
//	 }
//
//	 public static void LevelHelper(List<List<Integer>> list, com.xiong.test.TreeNode root, int height) {
//		if(root == null) return;
//		if(height >= list.size()) list.add(new LinkedList<Integer>());
//		list.get(height).add(root.val);
//		LevelHelper(list, root.left, height+1);
//		LevelHelper(list, root.right, height+1);
//	}
//
//	/***
//	 * 反转一个二叉树，使得成为镜像的
//	 * @param root
//	 */
//	public static com.xiong.test.TreeNode invertTree(com.xiong.test.TreeNode root) {
//		if(root == null) return null;
//		com.xiong.test.TreeNode temp = root.left;
//		root.left = root.right;
//		root.right = temp;
//		invertTree(root.left);
//		invertTree(root.right);
//		return root;
//	}
//
//	/***
//	 * 中序遍历
//	 * @param root
//	 * @return
//	 */
//    public static List<Integer> inorderTraversal(com.xiong.test.TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root != null) inorderTraversalCheck(list, root);
//        return list;
//    }
//
//    public static void inorderTraversalCheck(List<Integer> list, com.xiong.test.TreeNode root) {
//    	if (root.left != null) inorderTraversalCheck(list, root.left);
//        list.add(root.val);
//        if (root.right != null) inorderTraversalCheck(list, root.right);
//    }
//
//	/***
//	 * 后序遍历，返回数字
//	 * @param root
//	 * @return
//	 */
//	public static List<Integer> postOrder(com.xiong.test.TreeNode root) {
//		List<Integer> list = new ArrayList<>();
//        if (root != null) PostaddOrder(list,root);
//        return list;
//	}
//
//	public static void PostaddOrder(List<Integer> list, com.xiong.test.TreeNode root) {
//		if (root.left != null) PostaddOrder(list, root.left);
//		if (root.right != null) PostaddOrder(list, root.right);
//		if (root != null) list.add(root.val);
//	}
//
//	/***
//	 * 前序遍历二叉树
//	 * @param root
//	 * @return
//	 */
//	public static List<Integer> preOrder(com.xiong.test.TreeNode root) {
//		List<Integer> list = new ArrayList<>();
//        if (root != null) PreaddOrder(list,root);
//        return list;
//	}
//
//	public static void PreaddOrder(List<Integer> list, com.xiong.test.TreeNode root) {
//		if (root != null) list.add(root.val);
//		if (root.left != null) PreaddOrder(list, root.left);
//		if (root.right != null) PreaddOrder(list, root.right);
//	}
//
//	/***
//	 * Sum Root to Leaf Numbers
//	 * @param root
//	 * @return
//	 */
//	public static int preSumRoot(com.xiong.test.TreeNode root) {
//		return preSum(0, root);
//	}
//
//	public static int preSum(int sum, com.xiong.test.TreeNode root) {
//		if(root == null) return 0;
//		sum = sum*10 + root.val;
//		if(root.left == null && root.right == null) return sum;
//		return preSum(sum, root.left) + preSum(sum, root.right);
//	}
//
//	/***
//	 * 判断二叉树是否是镜像对称
//	 * @param root
//	 * @return
//	 */
//	public static boolean isSym(com.xiong.test.TreeNode root) {
//		if(root == null) return true;
//		return ischeckSym(root.left,root.right);
//	}
//
//	public static boolean ischeckSym(com.xiong.test.TreeNode left, com.xiong.test.TreeNode right) {
//		if(left == null && right == null) return true;
//		if(left == null || right == null) return false;
//		if (left.val == right.val)
//			return ischeckSym(left.left,right.right) && ischeckSym(left.right, right.left);
//	    return false;
//	}
//
//
//	/***
//	 * 判断是否是平衡二叉树
//	 * @param root
//	 * @return
//	 */
//	public static boolean isBalance(com.xiong.test.TreeNode root) {
//		if (root == null) return true;
//		int left = maxDepth(root.left);
//		int right = maxDepth(root.right);
//		if (left - right > 1 || left - right < -1) return false;
//		return isBalance(root.left) && isBalance(root.right);
//	}
//	/**
//	 * 判断一棵树是否是二叉搜索树
//	 * @param root
//	 * @return
//	 */
//
//	public static boolean isBST(com.xiong.test.TreeNode root) {
//		return isBSTpre(root, Long.MIN_VALUE, Long.MAX_VALUE);
//	}
//
//	public static boolean isBSTpre(com.xiong.test.TreeNode root, long min, long max) {
//		if(root == null) return true;
//		if (min < root.val && max > root.val)
//			return isBSTpre(root.left, min, root.val) && isBSTpre(root.right, root.val, max);
//        else  return false;
//	}
//
//	/**
//	 * 判断2个二叉树是否相同    递归的思想
//	 */
//	public static boolean checkTree(com.xiong.test.TreeNode p, com.xiong.test.TreeNode q) {
//		if (p == null && q == null) return true;
//		if (p == null || q == null) return false;
//		if (p.val == q.val) {
//			return checkTree(p.left, q.left) && checkTree(p.right, q.right);
//		}
//		return false;
//	}
//	/***
//	 * 二叉树的最大深度
//	 * @param node
//	 * @return
//	 */
//	public static int maxDepth(com.xiong.test.TreeNode node) {
//		if (node == null) return 0;
//		int left = maxDepth(node.left) + 1;
//		int right = maxDepth(node.right) + 1;
//		return left > right ? left : right ;
//	}
//	/***
//	 * 返回二叉树的最小深度
//	 * @param node
//	 * @return
//	 */
//	public static int minDepth(com.xiong.test.TreeNode node) {
//		if (node == null) return 0;
//		if (node.left == null)  return minDepth(node.right) + 1;
//		if (node.right == null) return minDepth(node.left) + 1;
//		int left = minDepth(node.left) + 1;
//		int right = minDepth(node.right) + 1;
//		return left > right ? right : left ;
//	}
//
}
