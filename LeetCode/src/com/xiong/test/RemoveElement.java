package com.xiong.test;

import java.util.HashSet;
import java.util.Set;


public class RemoveElement {
	
	/**
	 * Given nums = [1,1,1,2,2],
	   Your function should return length = 2, 
	   with the first two elements of nums being 1 and 2 respectively.
	   It doesn't matter what you leave beyond the new length.
	 * @param nums
	 * @return
	 */
	
	public static int removeElement(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		return set.size();
	}
	
	/***
	 * Given nums = [3,2,2,3], val = 3,
     * Your function should return length = 2, with the first two elements of nums being 2.
     * It doesn't matter what you leave beyond the returned length.
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int remove(int[] nums, int val) {
		int count=0 ,index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				count++;
			}
		}
		return nums.length-count;
	}
	
	
	
	public static void main(String[] args) {
		int[] num = {3,2,2,3};
		System.out.println(remove(num, 3));
		int[] nums = {1,1,1,2,2};
		System.out.println(removeElement(nums));
	}

}
