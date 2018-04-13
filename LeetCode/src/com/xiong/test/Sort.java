package com.xiong.test;
/***
 * 写出所有的排序算法
 * @author Eric
 *
 */
public class Sort {
	/***
	 * 冒泡排序
	 * 时间复杂度为n2 空间复杂度为n 
	 */
	public static int[] bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
	/***
	 * 插入排序 
	 * 时间复杂度       空间复杂度
	 * @param nums
	 */
	public static int[] insertSort(int[] nums) {
		int i,j;
		for (i = 1; i < nums.length; i++) {
			int temp = nums[i];
			for (j = i; j > 0 && nums[j-1] > temp; j--) {
				nums[j] = nums[j-1];
			}
			nums[j] = temp;
		}
		return nums;
	}
	/***
	 * 二分折半插入排序  在已经排序的前段使用二分法找到最大的那个
	 * @param nums
	 * @return
	 */
	public static int[] BinInsertSort(int[] nums) {
		return nums;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
		//Utils.show(bubbleSort(nums));
		Utils.show(insertSort(nums));
	}
}
