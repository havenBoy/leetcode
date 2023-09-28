package com.leetcode.leet_problems;

public class Test41_firstMissingPositive {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     *
     * @param nums 输入数组
     * @return 返回最大的数字
     */
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //第一步：将数字放在对应的下标位置，一次循环中存在不能一遍放置完毕
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int cur_num = nums[i];
                int tmp = nums[cur_num - 1];
                nums[cur_num - 1] = cur_num;
                nums[i] = tmp;
            }
        }
        //第二次遍历：将与下标数字不对齐的数字返回，如果遍历完毕都没有返回数字，则返回数组的长度+1
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    /**
     * 错误的解法：
     * 没有考虑类似：2,1这种顺序的数组
     * @param nums 输入参数
     * @return 返回数字
     */
    public static int firstMissingPositive_1(int[] nums) {
        int num = 1;
        for (int j : nums) {
            if (num == j) {
                num += 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,0};
        int[] nums = {3, 4, -1, 1};
        //int[] nums = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));
    }
}
