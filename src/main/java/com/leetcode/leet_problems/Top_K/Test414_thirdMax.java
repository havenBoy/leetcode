package com.leetcode.leet_problems.Top_K;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Test414_thirdMax {

    /**
     * 给你一个非空数组，返回此数组中第3大的数
     * 如果不存在，则返回数组中最大的数
     * 思路：
     * 1. 初始化三个变量，保证在三个变量内存在从大到小的顺序
     * 2. 遍历一次数组，维护从大到小的顺序
     * 3. 对于大于最大的数字，要将最大的数字赋个第二的数字, 第二个数字赋予第三个数字
     * 4. 注意：当前选取最小值为null, 而非最小值，只要数组中出现最小值，就会有问题
     * @param nums 数组
     * @return 返回结果值
     */

    public static int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (first == null || nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] < first && (null == second || nums[i] > second)) {
                third = second;
                second = nums[i];
            } else if (second != null &&  (nums[i] < second && (null == third || nums[i] > third))) {
                third = nums[i];
            }
        }
        return third == null ? first : third;
    }

    /**
     * 第二种解决方式
     * @param nums 输入数组
     * @return 返回值
     */
    public static int thirdMax1(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (Comparator.comparingInt(o -> o)));
        for (int i = 0; i < 3; i++) {
            queue.add(nums[i]);
        }
        for (int i = 3; i < nums.length; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
        System.out.println(thirdMax1(nums));
    }
}
