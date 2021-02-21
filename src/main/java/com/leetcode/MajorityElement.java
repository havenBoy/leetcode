package com.leetcode;

import java.util.Arrays;

public class MajorityElement {
	
	public static int divide(int dividend, int divisor) {
		return dividend/divisor;
	}
	
	/**
	 * Roman转阿拉伯数字    I, V, X, L, C, D and M.
	 * @param s  待处理字符串
	 * @return  返回数字值
	 */
	public static int romanToInt(String s) {
		int[] res = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				res[i] = 1000;
				break;
			case 'D':
				res[i] = 500;
				break;
			case 'C':
				res[i] = 100;
				break;
			case 'L':
				res[i] = 50;
				break;
			case 'X':
				res[i] = 10;
				break;
			case 'V':
				res[i] = 5;
				break;
			case 'I':
				res[i] = 1;
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < res.length-1; i++) {
			if(res[i] < res[i+1]) sum -= res[i];
			else sum+= res[i];
		}
		return sum+res[res.length-1];
	}
	
	/***
	 * 排序后，最多出现的数字在最中间位置
	 * @param nums
	 * @return
	 */
	public static int findMajority(int[] nums) {
		Arrays.sort(nums);
		return nums[(nums.length-1)/2];
	}
	
    public static void main(String[] args) {
    	
    	System.out.println(divide(7, -3));
		String string = "MCMXCIV";
		System.out.println(romanToInt(string));
	}

}
