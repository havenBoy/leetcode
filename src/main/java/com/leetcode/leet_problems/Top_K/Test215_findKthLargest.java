package com.leetcode.leet_problems.Top_K;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test215_findKthLargest {

    /**
     * 给你一个非空数组，返回此数组中第3大的数
     * 如果不存在，则返回数组中最大的数
     * 思路：
     * 1. 维护一个长度为k的优先队列
     * 2. 第一次加满这个队列
     * 3. 遍历剩余的数据，大于队列头的数据，则取出并新增新的元素
     * @param nums 数组
     * @return 返回结果值
     */

    public static int findKthLargest(int[] nums, int k) {
        if (k <= 0) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (Comparator.comparingInt(o -> o)));
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }

    /**
     * 错误思路： 会将重复的数字过滤掉
     */
    public static int findKthLargest1(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(((o1, o2) -> o2 - o1));
        set.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int count = 0;
        for (Integer i : set) {
            if (++count == k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,6,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
}
