package com.xiong.test;

import java.util.Arrays;

public class MajorityElement {
	/***
	 * 排序后，最多出现的数字在最中间位置
	 * @param nums
	 * @return
	 */
	public static int findMajority(int[] nums) {
		Arrays.sort(nums);
		return nums[(nums.length-1)/2];
	}

}
