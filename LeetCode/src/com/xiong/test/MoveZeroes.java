package com.xiong.test;

public class MoveZeroes {
	
	/***
	 * 移动数组中所有的0到数组的最右边
	 * 2个for循环时间复杂度太高
	 */
	public static int[] move(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] == 0 && nums[j] != 0) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				} 
			}
		}
		return nums;
	}
	/***
	 * 可以解决，但元素的相对位置还存在问题
	 * @param nums
	 * @return
	 */
	public static int[] move2(int[] nums) {
		int high = nums.length-1;
		for (int i = 0; high >= i; i++) {
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[high];
				nums[high] = temp;
				high--;
			}
		}
		return nums;
	}
	/***
	 * 尽可能的把不为0的数字移到数组的前边 ，然后其余的数字补充为0
	 * @param nums
	 * @return
	 */
	public static int[] move3(int[] nums) {
		if (nums.length == 0) return null;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index++] = nums[i];
			}
		}
		while (index < nums.length) {
			nums[index++] = 0;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		Utils.show(move3(nums));
	}

}
