package com.leetcode.leet_problems;

import java.util.*;

public class Test78_subsets {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。
     * 返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集
     *
     *
     * 思路：如果数组的长度为0，则返回的结果集为空
     * 任意一个至少存在一个元素的数组都会包含一个空子集，所以首先加入一个空子集
     * 第二个子集可以看作是在第一个子集的基础上加入此元素
     * @param nums 输入数组
     * @return 返回结果集
     */

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        result.add(list);
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int i1 = 0; i1 < size; i1++) {
                List<Integer> integers = result.get(i1);
                result.add(new LinkedList<>(integers));
                result.get(result.size() - 1).add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3};
        List<List<Integer>> subsets = subsets(nums);

        //展示结果
        subsets.forEach((each) -> {
            each.forEach(System.out::print);
            System.out.println("/");
        });
        System.out.println(subsets.size());
    }
}
