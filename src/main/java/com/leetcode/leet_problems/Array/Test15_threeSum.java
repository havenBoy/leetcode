package com.leetcode.leet_problems.Array;

import java.util.*;

public class Test15_threeSum {

    /*
        给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c
        使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组
        注意：答案中不可以包含重复的三元组
     */

    /**
     * 给定数组和一个目标值，找出3个数字之和等于目标值
     *
     * @param array 给出的数组
     * @return 返回所有可能的组合
     */
    public static List<List<Integer>> threeSum(int[] array) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[k] + array[j] + array[i] != 0) {
                        continue;
                    }
                    set.add(new ArrayList<Integer>(Arrays.asList(array[i], array[j], array[k])));
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}
