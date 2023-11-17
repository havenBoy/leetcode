package com.leetcode.leet_problems;

import java.util.Arrays;

public class Test252_canAttendMeetings {


    /**
     * N * 2个二位数组，第一个数字为开始时间，第二个为结束时间
     * 判断是否可以同时参与所有的会议
     * 思路： 将
     * @param nums 输入二维数组
     * @return 返回是否可以同时参会的标志
     */
    public static boolean canAttendMeetings(int[][] nums) {
        Arrays.sort(nums[0]);
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,30}, {5,10}, {15, 20}};
    }
}
