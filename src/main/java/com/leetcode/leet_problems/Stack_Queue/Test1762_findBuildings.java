package com.leetcode.leet_problems.Stack_Queue;

import java.util.*;

public class Test1762_findBuildings {

    /*
     * 题目描述：
     * 有 n 座建筑物。给你一个大小为 n 的整数数组 heights 表示每一个建筑物的高度。
     * 建筑物的右边是海洋。如果建筑物可以无障碍地看到海洋，则建筑物能看到海景。
     * 确切地说，如果一座建筑物右边的所有建筑都比它 矮 时，就认为它能看到海景。
     * 返回能看到海景建筑物的下标列表（下标 从 0 开始 ），并按升序排列。
     */

    public static int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] < heights[i]) {
                deque.poll();
            }
            if (deque.isEmpty()) {
                list.add(i);
            }
            deque.push(i);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,2,2};
        System.out.println(Arrays.toString(Arrays.stream(findBuildings(arr)).toArray()));
    }

}
