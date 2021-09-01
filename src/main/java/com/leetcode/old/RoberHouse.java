package com.leetcode.old;

public class RoberHouse {
	
	/***
	 * 也是属于动态规划问题
	 * 计算数组中连续子数组最大的和
	 * @param nums
	 * @return
	 */
	public static int getMaxRes(int[] nums) {
		if (nums.length == 0) return 0;
		int result = 0;
		int max = Integer.MIN_VALUE;//防止数组中有负数的情况
		for (int i = 0; i < nums.length; i++) {
			if (result <= 0) result = nums[i];
			else 
				result += nums[i] ;
			if (result > max) max = result;
		}
		return max;
	}
	
	/***
	 * 属于动态规划问题
	 * 爬楼梯，一次可以爬1个或者2个，上n个台阶有多少方法
	 * @param n
	 * @return
	 */
	public static int upstairs(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		return upstairs(n-1) + upstairs(n-2);
	}
	/***
	 * 斐波那契数列
	 * 爬楼梯，一次可以爬1个或者2个，上n个台阶有多少方法（非递归）
	 * @param n
	 * @return
	 */
	public static int upstairs2(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int[] array = new int[n+1];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i < array.length; i++) {
			array[i] =array[i-1] + array[i-2];
		}
		return array[n];
	}
	//打劫问题
	public static int robber(int[] nums) {
		int profit = 0;
		int take = 0,noTake = 0;
		for (int i = 0; i < nums.length; ++i) {
			take = noTake + nums[i];
			noTake = profit;
			profit = Math.max(take, noTake);
		}
		return profit;
	}
	//奇数和偶数的问题 思路
	public static int robber2(int[] nums) {
		int first = 0,last = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i%2 == 0) {
				first = Math.max(first+nums[i], first);
			} else {
				last = Math.max(last+nums[i], last);
			}
		}
		return Math.max(first, last);
	}
	//假设最后一个数字和前边的数字相邻
	public static int robber3(int[] nums) {
		return 0;
	}
	
	
	public static void main(String[] args) {
		int[] numss = {-3,-1,-1,-3};
		System.out.println(getMaxRes(numss));
		
		int[] nums = {2,5,3,4,5};
		System.out.println(robber(nums));
		System.out.println(robber2(nums));
		System.out.println(upstairs(5));
		System.out.println(upstairs2(5));
	}

}
