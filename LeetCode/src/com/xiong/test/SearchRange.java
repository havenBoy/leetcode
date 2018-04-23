package com.xiong.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchRange {
	/***
	 * 二分查找法,待做
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int [] array = new int[2];
		array[0] = -1;array[1] = -1;
		int low = 0, high = nums.length-1;
		while (low <= high) {
			int mid = (low + high)/2;
			if (nums[mid] == target) {
				array[0] = mid;
				while(mid <= nums.length-1 && mid >= 0) {
					if (nums[mid++] != target) {
						array[1] = mid-1;
					} else if (nums[mid--] != target){
						array[0] = mid + 1;
					}
				}
				break;
			} else if (nums[mid] > target){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return array;
	}
	/***
	 * 遍历一遍数组，记录等于目标值的下标，之后返回下标的最大值与最小值
	 * 时间复杂度为n
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange2(int[] nums, int target) {
		List<Integer> list = new ArrayList<>();
		int[] array = new int[2];
		array[0] = -1;
		array[1] = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				list.add(i);
			}
		}
		Collections.sort(list);
		if (list.size() != 0) {
			array[1] = Collections.max(list);
			array[0] = Collections.min(list);
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,7,8,8,8,10};
		Utils.show(searchRange2(nums, 6));
		Utils.show(searchRange(nums, 8));
	}

}
