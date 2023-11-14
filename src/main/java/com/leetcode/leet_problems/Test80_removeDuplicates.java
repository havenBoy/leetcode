package com.leetcode.leet_problems;

import java.util.Arrays;

public class Test80_removeDuplicates {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
     * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组
     * 并在使用 O(1) 额外空间的条件下完成。
     * @param nums 输入数组
     * @return 返回数组长度
     *
     */

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int num = nums[0], count = 0 ,index = 2;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num && count <= 2) {
                count++;
            } else {
                nums[index++] = nums[i];
                num = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
