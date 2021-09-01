package com.leetcode.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StockProblem {
	
	/*
	 * 计算出股票的最高收益点  时间复杂度是n2
	 * **/
	public static int getSell(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j] - nums[i] > 0) {
					list.add(nums[j] - nums[i]);
				}
			}
		}
		Collections.sort(list);
		if (list.size() == 0) {
			return 0;
		} else {
			return list.get(list.size()-1);
		}
	}
	//时间复杂度为n 思路：不断修改最小的买入点，不断保存最大的利润点
	public static int getSellBest(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		int buyNum = nums[0];
		int profit = 0;
		for (int i = 1; i < length; i++) {
			if (nums[i] > buyNum) {
				profit = (nums[i] - buyNum) > profit ? (nums[i] - buyNum) : profit ;
			} else {
				buyNum = nums[i];
			}
		}
		return profit;
	}
	//允许多笔交易     利润最大之和应该为相邻元素之间差的和
	public static int getSellBest2(int[] nums) {
		int profit = 0;
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i] < nums[i+1]) {
				profit += nums[i+1] - nums[i];
			}
		}
		return profit;
	}
/*	//允许2笔交易     找出2组数字，使其差值的和最大  并且是从左到右的顺序
	public static int getSellBest3(int[] nums) {
		List<Integer> list = new ArrayList<>();

	}*/
	public static void main(String[] args) {
		
		int[] nums = {6,1,3,2,4,7};
		System.out.println(getSell(nums));
		System.out.println(getSellBest(nums));
		System.out.println(getSellBest2(nums));
		//System.out.println(getSellBest3(nums));
	}

}
