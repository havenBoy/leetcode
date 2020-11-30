package com.leetcode;

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
	 * 冒泡排序   每次重复比较2个数字，满足大小关系不交换，否则交换
	 * 稳定性 ： 稳定
	 * 时间复杂度为n2      空间复杂度为n 
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
	/**
	 * 插入排序 ： 每次使得左边的数组是有序的；
	 * 时间复杂度   n^2   空间复杂度  n
	 * 稳定性 ： 稳定
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
	/***
	 * 快速排序    关于在于找出那个基准值
	 * 时间复杂度 nlogN      空间复杂度  n
	 * @param nums
	 */
	public static void quickSort(int[] nums, int low, int high) {
		if(low < high) {
			int mid = partion(nums, low, high);
			quickSort(nums, 0, mid-1);
			quickSort(nums, mid+1, high);
		}
	}
	//找出基准
	public static int partion(int[] arr, int low, int high) {
		while(low < high) {
			while(low < high && arr[low] <= arr[high]) {
				low++;
			}
			if(low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
			while(low < high && arr[low] <= arr[high]) {
				high--;
			} 
			if(low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		return low;
	}
	/***
	 * 选择排序: 每趟选出一个最小或者最大的数字在首位，
	 *           然后再对剩下的数据重复
	 * 时间复杂度    n^2   空间复杂度 n
	 * 稳定性  : 不稳定
	 * @param nums
	 */
	public static int[] selectSort(int[] nums) {
		for(int i=0; i< nums.length-1;i++) {
			int min = i;
			for(int j=i+1; j<nums.length;j++) {
				if(nums[min] > nums[j]) {
					min = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[min];
			nums[min] = temp;
		}
		return nums;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
		//Utils.show(bubbleSort(nums));
		//sortColor(nums);
		//selectSort(nums);
		//quickSort(nums, 0, nums.length-1);
		insertSort(nums);
		com.leetcode.Utils.show(nums);
	}
}
