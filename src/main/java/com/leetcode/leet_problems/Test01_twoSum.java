package com.leetcode.leet_problems;

import java.util.HashMap;

public class Test01_twoSum {

    /*
	 * 题目描述：
	 * 给定一个整数数组 nums和一个整数目标值 target，
	 * 请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
	 *
	 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
	 * 你可以按任意顺序返回答案。
	 */

    /**
     * 指针碰撞法（二分）
     *
     * @param nums  传入数组
     * @param target  目标数字
     * @return  返回的2个数字组成的数组
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                array[0] = low + 1;
                array[1] = high + 1;
                return array;
            } else if (nums[low] + nums[high] < target) {
                low += 1;
            } else {
                high -= 1;
            }
        }
        return array;
    }

    /**
     * 近似于冒泡法
	 * @param array  传入数组
	 * @param num  目标数字
	 * @return  返回的2个数字组成的数组
     */
    public static int[] twoSum3(int[] array, int num) {
        int[] return_array = {-1, -1};
        int len = array.length;
        int i = 0;
        while (i < len) {
            int target = num - array[i];
            for (int j = i + 1; j < len; j++) {
                if (target == array[j]) {
                    return_array[0] = i;
                    return_array[1] = j;
                    return return_array;
                }
            }
            i++;
        }
        return return_array;
    }


    /**
     * 假设原数组是无序的
     *
	 * @param nums  传入数组
	 * @param target  目标数字
	 * @return  返回的2个数字组成的数组
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] array = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
		for (int num : nums) {
			if (map.containsKey(target - num)) {
				array[0] = num;
				array[1] = target - num;
				break;
			}
		}
        return array;
    }

    /***
     * 2个数字的组合等于目标值
	 * @param nums  传入数组
	 * @param target  目标数字
	 * @return  返回的2个数字组成的数组
     */
    public static int[] twoSum4(int[] nums, int target) {
        int[] array = {-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                    break;
                }
            }
        }
        return array;
    }

    /**
     *
	 * @param nums  传入数组
	 * @param target  目标数字
	 * @return  返回的2个数字组成的数组
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] array = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                array[0] = i;
                array[1] = map.get(target - nums[i]);
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 2};
        int target = 4;
        //int[] array = twoSum(nums, target);
        //int[] array = twoSum1(nums, target);
        //System.out.println(twosum(nums, target)[0]);
        //System.out.println(twosum(nums, target)[1]);

        int[] array = twoSum3(nums, target);
        System.out.println(array[0]);
        System.out.println(array[1]);
    }

}
