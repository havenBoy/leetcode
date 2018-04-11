package com.xiong.test;

public class RoberHouse {
	
	
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
		int[] nums = {2,5,3,4,5};
		System.out.println(robber(nums));
		System.out.println(robber2(nums));
		System.out.println(upstairs(5));
	}

}
