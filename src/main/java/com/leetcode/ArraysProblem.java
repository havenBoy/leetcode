package com.leetcode;

public class ArraysProblem {

    /**
     * 原数组操作将目标数字放置在最后
     * array  数组
     * target 目标数字
     * @return
     */
    public static int getSameNum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        int count = 0;
        while (start < end) {
            while (target == nums[start]) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                count++;
            }
            start++;
            while (target != nums[end]) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                end--;
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,2,1};

        System.out.println(getSameNum(nums, 2));
    }
}
