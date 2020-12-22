package com.leetcode;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月22日 下午10:45:49
 * 类说明  整数的拆分，使得拆分的数字的乘积最大
*/

public class IntegerBreak {
	/**
	 * 拆分的数字应该与3更接近，一个数字对3取余有3种情况：
	 * 1.余数为0，那么全部取3
	 * 2.余数为1时,取2*2较大
	 * 3.余数为2时,取1个2，其余的取3
	 * @param n
	 * @return
	 */
	public static int integerBreak1(int n) {
		int res = 1;
		if (n <= 2) return 1;
		if (n == 3) return 2;
		while (n > 0) {
			if (n % 3 == 1) {
				n -= 4;
				res *= 4;
			} else if (n % 3 == 2) {
				n -= 2;
				res *= 2;
			} else {
				n -= 3;
				res *= 3;
			}
		}
		return res;
	}

	/**
	 * 动态规划解决
	 * 思路：假设当前的需要拆分的数字为i,产生最大的积为k,则dp[i]=k
	 * 数字0和1是不可拆分的数字
	 * 当需要拆分的数字为i时，可有2种拆分结果，第一种为
	 * @param n 需要拆分的数字
	 * @return 返回产生的最大积
	 */
	public static int integerBreak(int n) {
		if (n <= 1) return 0;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(integerBreak1(4));
		System.out.println(integerBreak(10));
	}

}
