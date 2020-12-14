package com.leetcode;

import java.util.Vector;

/**
 * 斐波那契数列，递归
 * @version 2.0.0
 * @author 赵小雄59782
 * @date 2020/11/30 11:23
 */
public class Test02 {

    public static int fibonacii(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacii(n - 1) + fibonacii(n - 2);
    }

    public static int finbonaci2(int n) {
        if (n == 0) {
            return 0;
        }
        int first = 1, second = 1;

        int result  = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            int tmp = second;
            second = first + second;
            first = tmp;
        }
        return second;
    }

    //记事本 dp[]
    public static int finbonaci3(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }

    public static int getMinCoins(int[] nums, int target) {
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

    public static int continueMaxSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //
    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int first = 1, second = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = second;
            second = first + second;
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,8};

        System.out.println(fibonacii(6));
        System.out.println(finbonaci2(11));
        System.out.println(finbonaci3(11));
        System.out.println(numWays(10));
        System.out.println(getMinCoins(nums, 4));

        int[] numss = {-2,-1,3};
//        int[] numss = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(continueMaxSum(numss));
    }

}