package com.leetcode.leet_problems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test39_combinationSum {

    /*
      给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target
      找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合
      candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的
     */

    /**
     * 允许多次使用，但有和结果值限制
     * @param candidates  给定数组
     * @param target 目标值
     * @return 返回可能的集合
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        combinationSum(candidates, target, state, 0, result);
        return result;
    }

    public static void combinationSum(int[] candidates, int target, List<Integer> state, int start, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(state));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            state.add(candidates[i]);
            //这里的i值确定了是否可以重复取，本题中是可以取的，实际为i，不可以取的话是i+1
            combinationSum(candidates, target - candidates[i], state, i, result);
            state.remove(state.size() - 1);
        }
    }

    /**
     * 和确定，且子集内元素个数确定
     * @param candidates 给定数组
     * @param target 目标值
     * @param count  元素个数
     * @return 返回集合结果
     */
    public static List<List<Integer>> combinationSum1(int[] candidates, int target, int count) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        combinationSum1(candidates, target, state, 0, result, count);
        return result;
    }

    public static void combinationSum1(int[] candidates, int target, List<Integer> state, int start, List<List<Integer>> result, int count) {
        if (target == 0 && state.size() == count) {
            result.add(new ArrayList<>(state));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            state.add(candidates[i]);
            combinationSum1(candidates, target - candidates[i], state, i, result, count);
            state.remove(state.size() - 1);
        }
    }



    public static void main(String[] args) {
        //输入: candidates = [2,3,5], target = 8
        //输出: [[2,2,2,2],[2,3,3],[3,5]]
        int[] arr = {2,3,5};
        int target = 8, count = 4;
        System.out.println(Arrays.toString(combinationSum(arr, target).toArray()));
        System.out.println(Arrays.toString(combinationSum1(arr, target, count).toArray()));
    }
}
