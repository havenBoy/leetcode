package com.leetcode;

public class FindIndex {
	
	/**
	 * Given a sorted array and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * 
	 * 二分查找
	 * @param nums
	 * @param num
	 * @return
	 */
	
	public static int finIndex(int[] nums,int num) {
		int low = 0,high = nums.length-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if (nums[mid] == num) {
				return mid;
			} else if (nums[mid] > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int num = 7;
		System.out.println(finIndex(nums, num));
	}

}
