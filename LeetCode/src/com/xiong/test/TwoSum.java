package com.xiong.test;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
		 int[] array = new int[2];
	     for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					array[0] = i;
					array[1] = j;
					break;
				}
			}
		}
	    return array;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {2, 7, 11, 15};
		int target = 18;
		int[] array = twoSum(nums, target);
		System.out.println(array[0] + ";" + array[1]);
	}

}
