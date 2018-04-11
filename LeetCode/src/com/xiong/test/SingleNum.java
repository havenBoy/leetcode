package com.xiong.test;

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
/*	//三三出现，找出单独的数字
	public static int getSingleThree(int[] nums) {
		
	}
	//2个单独出现的数字
	public static int[] getSingleNumTwo(int[] nums) {
		
	}*/
	
	public static void main(String[] args) {
		System.out.println(1^2^3);
		int[] nums = {1,1,2,3,3};
		System.out.println(getSingleNum(nums));
	}

}
