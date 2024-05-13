package com.leetcode.leet_problems.DP;

public class Test121_Stock {

    /*
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0
     */

    /**
     * 传入数组
     * @param nums 传入数组
     * @return 返回能够返回的最大利益
     */
    public static int stock(int[] nums) {
        int profit = 0, cost = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cost = Math.min(nums[i], cost);
            profit = Math.max(nums[i] - cost, profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(stock(arr));
    }
}
