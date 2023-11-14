package com.leetcode.leet_problems.Top_K;

import java.util.*;

public class Test347_topKFrequent {

    /**
     * 给定一个非空的数组，与一个常数K
     * 返回最经常出现的数字前K个数字
     * 思路：
     * 1. 遍历一次数组，计算每个数字出现的次数，将结果使用Map存储
     * 2. 将map转换为优先级队列结构，优先级的数字由value值来确定
     * 3. 出栈K次，将每个数字写入数组
     * @param nums 数组
     * @param k    常数K
     * @return 返回数组
     */

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums.length <= 1 || k < 1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(map.entrySet());
        int index = 0;
        while ((k--) > 0 && !pq.isEmpty()) {
            result[index++] = pq.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,2,1,1};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
