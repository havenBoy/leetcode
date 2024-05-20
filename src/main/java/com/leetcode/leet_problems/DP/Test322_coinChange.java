package com.leetcode.leet_problems.DP;

import java.util.Arrays;

public class Test322_coinChange {

    /*
     * 题目描述：
     * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，
     * 每种硬币的数量无限，再给一个总金额 amount，
     * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
     */


    /**
     * 动态规划思想
     * @param target 目标值
     * @param arr 给定数组
     * @return 返回最少需要的硬币数量
     */
    public static int coinChange(int[] arr, int target) {
        if (target == 0 || arr.length == 0) {
            return 0;
        }
        if (target < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int j : arr) {
            int sub = coinChange(arr, target - j);
            if (sub == -1) continue;
            res = Math.min(res, sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 贪心算法思想
     * @param target 目标值
     * @param arr 给定数组
     * @return 返回最少需要的硬币数量
     */
    public static int coinChange2(int[] arr, int target) {
        if (target == 0 || arr.length == 0) {
            return 0;
        }
        if (target < 0) {
            return -1;
        }
        Arrays.sort(arr);
        int res = target, index = 0;
        while (index < arr.length) {
            int count = 0;
            for (int i = arr.length - ++index; i >= 0; i--) {
                if (target >= arr[i]) {
                    int cc = target / arr[i];
                    target %= arr[i];
                    count += cc;
                }
                if (target == 0) {
                    return count;
                }
            }
            target = res;
        }
        return -1;
    }

    public static int coinChange11(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = target + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (i - j < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - j]);
            }
        }
        return (dp[target] == target + 1) ? -1 : dp[target];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{186,419,83,408};
        int target = 6249;
//        System.out.println(coinChange(arr, target));
//        System.out.println(coinChange2(arr, target));
        System.out.println(coinChange11(arr, target));
    }

}
