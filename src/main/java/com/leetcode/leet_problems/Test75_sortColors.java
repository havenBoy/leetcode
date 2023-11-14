package com.leetcode.leet_problems;

import java.util.Arrays;

public class Test75_sortColors {

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
     * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
     *
     * @param nums 输入数组
     */
    public static void sortColors(int[] nums) {
        int count_1 = 0, count_2 = 0, count_3 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count_1++;
            } else if (nums[i] == 1) {
                count_2++;
            } else if (nums[i] == 2) {
                count_3++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count_1) {
                nums[i] = 0;
            } else if (i < count_2 + count_1) {
                nums[i] = 1;
            } else if (i < count_1 + count_2 + count_3){
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
