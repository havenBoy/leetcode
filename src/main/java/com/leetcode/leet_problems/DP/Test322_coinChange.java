package com.leetcode.leet_problems.DP;

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

    public static int coin(int[] arr, int target) {
        return coinChange(arr, target);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        int target = 16;
        System.out.println(coin(arr, target));
    }

}
