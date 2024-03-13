package com.leetcode.leet_problems.Top_K;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * 最普遍的解决方式，缺点是会出现重复的数字
     * @param nums 输入数组
     * @return 返回值
     */
    public static int thirdMaxNew(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (Comparator.comparingInt(o -> o)));
        for (int num : nums) {
            if (queue.size() < 3) {
                queue.offer(num);
            } else if (queue.peek() <= num) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.poll();
    }

    public static int thirdMaxNew(int[] nums, int k) {
        List<Integer> set = new ArrayList<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        return collect.size() >= k ? collect.get(collect.size()-k) : collect.get(collect.size()-1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{20, 20, 30, 1, 30};
        System.out.println(thirdMax(nums1));
        System.out.println(thirdMaxNew(nums1));
        System.out.println(thirdMaxNew(nums1, 3));

    }
}
