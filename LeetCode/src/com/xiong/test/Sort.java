package com.xiong.test;

/***
 * 写出所有的排序算法
 * @author Eric
 *
 */
public class Sort {
	
	/**
	 * 对3个重复元素的排序
	 * @param nums
	 */
	public static void sortColor(int[] nums) {
		if(nums.length <= 1) return ;
		int[] res = {0,0,0};
		for (int i = 0; i < nums.length; i++) {
			res[nums[i]] ++;
		}
		int index = 0;
		for (int i = 0; i < res[0]; i++) {
			nums[index++] = 0;
		}
		for (int i = 0; i < res[1]; i++) {
			nums[index++] = 1;
		}
		for (int i = 0; i < res[2]; i++) {
			nums[index++] = 2;
		}
	}
	
	
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
		int[] nums = {2,0,2,1,1,0};
		//int[] nums = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
		//Utils.show(bubbleSort(nums));
		sortColor(nums);
		Utils.show(nums);
	}
}
