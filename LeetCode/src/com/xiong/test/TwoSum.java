package com.xiong.test;

import java.util.HashMap;

public class TwoSum {
	
	public static int[] twosum(int[] nums, int target) {
		int[] array = new int[2];
		int low = 0, high = nums.length-1;
		while(low < high) {
			if(nums[low] + nums[high] == target) {
				array[0] = low + 1;
				array[1] = high + 1;
				return array;
			} else if (nums[low] + nums[high] < target) {
				low += 1;
			} else {
				high -= 1;
			}
		}
		return array;
	}
	
	
	/**
	 * 原数组是无序的
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSums(int[] nums,int target) {
		int[] array = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i+1);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				array[0] = nums[i];
				array[1] = target-nums[i];
				break;
			}
		}
		return array;
	}
	
	/***
	 * 2个数字的组合等于目标值
	 * @param nums
	 * @param target
	 * @return
	 */
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
		int target = 9;
		int[] array = twoSum(nums, target);
		//int[] array = twoSum1(nums, target);
		System.out.println(twosum(nums, target)[0]);
		System.out.println(twosum(nums, target)[1]);
	}

}
