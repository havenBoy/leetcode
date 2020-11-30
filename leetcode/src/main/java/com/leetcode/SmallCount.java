package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SmallCount {
	
	/***
	 * 计算出一个数组中每个数字比右边的数字小的个数
	 * 比较采用冒泡的思想依次与其他数字进行比较，但时间复杂度较高
	 * @param nums
	 * @return
	 */
	
	public static List<Integer> smallCount(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums.length == 0) return list;
		for (int i = 0; i < nums.length-1; i++) {
			int count = 0;
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					count++;
				}
			}
			list.add(count);
		}
		list.add(0);
		return list;
	}
	
	public static void show(List<Integer> list) {
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 2, 6, 1};
		show(smallCount(nums));
	}

}
