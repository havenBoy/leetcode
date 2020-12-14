package com.leetcode;

import java.util.HashMap;

public class SingleNum {
	
	/***不能占用多余的内存空间
	 * 一个数组中只有2个数字是单独出现的，其他的都是成对出现的
	 * 一个数组中只有一个数字是单独存在的，其他的都是成对的，找出这个数字
	 * 一个数组中只有一个数字是单独的，其他的都是3个3个存在的，找出这个数字
	 * @param nums
	 * @return
	 */
	
	//一个数与自己做与操作为0,0与其他的数字做与结果为其他的数字
	public static int getSingleNum(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}
	//三三出现，找出单独的数字（虽然实现，但是时间复杂度较高，待改善）
	public static int getSingleThree(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i])+1);
		}
		for (Integer key : map.keySet()) {
			if(map.get(key) == 1) return key;
		}
		return -1;
	}
	//2个单独出现的数字（虽然实现，但是时间复杂度较高，待改善）
	public static int[] getSingleNumTwo(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i])+1);
		}
		for (Integer key : map.keySet()) {
		    if(map.get(key) == 1) res[index++] = key;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,3};
		Utils.show(getSingleNumTwo(nums));
	}

}
