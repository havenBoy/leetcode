package com.leetcode.leet_problems.DP;

public class Test198_Rob {

    /*
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
     */

    /**
     * 代表商店的金币数量的数组
     * @param nums 传入数组
     * @return 返回能够返回的最大金币数量
     */
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(robbery(arr));
    }
}
