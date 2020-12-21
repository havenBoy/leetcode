package com.leetcode;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月22日 下午10:45:49
 * 类说明  整数的拆分，使得拆分的数字的乘积最大
 * 拆分的数字应该与3更接近，一个数字对3取余有3种情况，
 * 1.余数为0，那么全部取3
 * 2.余数为1时,取2*2较大
 * 3.余数为2时,取1个2，其余的取3
 * 也可当做动态规划处理
 */
public class IntergerBreak {
	
	public static int intergerBreak(int n) {
		int res = 1;
		if (n <= 2) return 1;
		if (n == 3) return 2;
		if (n >= 4) {
			while (n > 0) {
				if (n % 3 == 1) {n -= 4; res *= 4;}
				if (n % 3 == 2) {n -= 2; res *= 2;}
				if (n % 3 == 0) {n -= 3; res *= 3;}
			}
		}
		return res;
	}

	public static int integerBreak(int n) {
		int[] dp = new int[n+1];
		if (n <= 2) return 1;
		if (n == 3) return 2;
		dp[2] = 1;
		dp[3] = 2;
		for (int i = 3; i < n; i++) {
			for (int j = 1; j <i; j++) {
				dp[i] = Math.max(dp[i], 0);
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(intergerBreak(10));
	}

}
