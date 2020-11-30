package com.leetcode;

import java.util.Arrays;

public class SearchRotatedArray {
	/***
	 * 在旋转数组中返回目标值的下标(考虑存在重复的元素？)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchRotated(int[] nums, int target) {
		int low = 0, high = nums.length-1;
		while (low <= high) {
			int mid = (low + high)/2;
			if (nums[mid] == target) return mid;
			if (nums[mid] < nums[high]) {
				if (nums[mid] < target && nums[high] >= target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (nums[low] <= target && nums[mid] > target)  {
					high = mid -1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
	/***
	 * 在旋转数组中返回最小的数字(考虑存在重复的元素？)
	 * @param nums
	 * @return
	 */
	public static int findMin(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int low = 0, high = nums.length-1;
		while (low < high) {
			int mid = (high + low)/2;
            if (mid > 0 && nums[mid] < nums[mid-1]) {
				return nums[mid];
			}
            if (nums[low] <= nums[mid] && nums[high] < nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return nums[low];
	}
	
	public static void main(String[] args) {
		int[] nums = {3,5,0,1,2};
		Arrays.sort(nums);
		com.xiong.test.Utils.show(nums);
		//System.out.println(searchRotated(nums, 3));
		//System.out.println(findMin(nums));
	}

}
