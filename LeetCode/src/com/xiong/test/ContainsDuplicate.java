package com.xiong.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月11日 下午9:43:33
 * 类说明
 */
public class ContainsDuplicate {
	
	/***
	 * 存在相同的返回true  否则返回false
	 * @param nums
	 * @return
	 */
    public static boolean containsDuplicate(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return false;
		}
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		return set.size() != nums.length;
	
	}
    
    public static boolean containsDuplicateForK(int[] nums,int k) {
    	for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] == nums[j] && j-i <= k) {
					return true;
				}
			}
		}
    	return false;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {2,2};
		System.out.println(containsDuplicateForK(nums, 3));
		System.out.println(containsDuplicate(nums));
	}

}
