package com.leetcode.old;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月11日 下午9:43:33
 * 类说明
 */
public class ContainsDuplicate {
	
	
	/***
	 * 数组中查找是否存在相同的数字
	 * 存在相同的返回true  否则返回false
	 * @param nums
	 * @return
	 */
    public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		if (nums.length == 0 || nums.length == 1) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		return set.size() != nums.length;
	
	}
    /***
     * 在数组中找到相同的数字使得下标的差值不大于k
     * 思路：使用另外的空间，利用hashmap的不可重复性，找到那个重复的时间点，
     *     此时计算下标的差值是否满足小于k
     * 2个循环的时间复杂度太高
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsDuplicateForK(int[] nums,int k) {
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if (hashMap.containsKey(nums[i])) {
    			if (i-hashMap.get(nums[i]) <= k) {
					return true;
				}
			}
			hashMap.put(nums[i], i);
		}
    	return false;
	}
    /***
     * 数组中查找是否存在2个数字使得下标差值小于k,并且数字的差值小于t
     * 思路：维持一个大小为K的窗口，在窗口中判断是否存在一个数对之间的差值小于等于t
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (j-i <= k && nums[j]-nums[i] <= t) {
					return true;
				}
			}
		}
    	return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,2};
		System.out.println(containsNearbyAlmostDuplicate(nums, 2, 1));
		System.out.println(containsDuplicateForK(nums, 3));
		System.out.println(containsDuplicate(nums));
	}

}
