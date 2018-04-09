package com.xiong.test;

import java.util.HashMap;

public class TwoSum {
	
	/*
	 * 有且只有一个，只要找出立马跳出循环
	 * */
	//时间复杂度为n2
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
	
	//另外一种是以一个数字为准，找到数组中另外的一个数字，那一招一
	public static int[] twoSum1(int[] nums,int target) {
		int[] array = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i+1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				array[0] = i;
				array[1] = map.get(target-nums[i]);
				break;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 18;
		int[] array = twoSum(nums, target);
		//int[] array = twoSum1(nums, target);
		System.out.println(array[0] + ";" + array[1]);
	}

}
