package com.leetcode;

import javax.swing.Spring;

/**
 * @version 2.0.0
 * @author 赵小雄59782
 * @date 2020/12/8 14:56
 */
public class Test05 {

    public static int robbery(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i-2] + nums[i], res[i-1]);
        }
        return res[nums.length-1];
    }

    public static int stock(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int profit = 0, cost = nums[0];
        for (int i : nums) {
            cost = Math.min(cost, i);
            profit = Math.max(profit, i - cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,3,4,3,10};
        System.out.println(robbery(arr));
        System.out.println(stock(arr));
    }

}
