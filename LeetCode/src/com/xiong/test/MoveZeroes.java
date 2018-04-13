package com.xiong.test;

public class MoveZeroes {
	
	/***
	 * 移动数组中所有的0到数组的最右边
	 * 2个for循环时间复杂度太高
	 */
	public static int[] move(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] == 0 && nums[j] != 0) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				} 
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,0,0,0,2};
		Utils.show(move(nums));
	}

}
