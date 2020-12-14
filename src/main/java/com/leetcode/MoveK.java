package com.leetcode;

/***
 * @author Xiong
 * 数组向右移动K位后的数组  1,2,3,4  2位    3,4,1,2
 */
public class MoveK {
	
	public static int[] reverse(int[] nums, int i, int j) {
		while(i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
		return nums;
	}
	
	public static int[] move(int[] nums, int k) {
		k = k > nums.length ? k-=nums.length : k;//判断K是否大于数组的长度
		nums = reverse(nums, 0, nums.length-1-k);
		nums = reverse(nums, nums.length-k, nums.length-1);
		return reverse(nums, 0, nums.length-1);
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		Utils.show(move(nums, 3));
	}

}
