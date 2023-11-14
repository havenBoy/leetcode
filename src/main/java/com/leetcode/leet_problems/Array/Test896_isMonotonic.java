package com.leetcode.leet_problems.Array;

public class Test896_isMonotonic {

    /*
     * 如果数组是单调递增或单调递减的，那么它是单调的
     * 判断一个数组是否为单调数组
     */

    /**
     * 如果是数组的数量小于1，则必定为递增数组
     * 数组数量值大于等于2时，判断下总体的趋势，
     * 判断的方法为比较数组第一个值与最后一个值的大小
     * 结果分为三种结果，一种是递增，一种是递减，还有一种是相等
     * 递增与递减的情况可以简单判断，思路相同
     * 如果是相同的话，代表所有的数字必须为相同的数字才能满足单调的条件
     *
     * @param nums 输入数组
     * @return 返回结果
     */
    public static boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        boolean flag = true;
        if (nums[0] < nums[nums.length -1]) {
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    continue;
                }
                if (nums[i] > nums[i+1]) {
                    flag = false;
                    break;
                }
            }
        } else if (nums[0] > nums[nums.length - 1]) {
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    continue;
                }
                if (nums[i] < nums[i+1]) {
                    flag = false;
                    break;
                }
            }
        } else {
            int num = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != num) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 思路2：
     * 保持2个变量保存每次比较后的结果，叠加后与数组的长度比较
     * 只要有一个变量等于数组的长度即可认为数组是单调的
     * 注意考虑到，元素均为相同的数字
     * @param nums 输入数组
     * @return 返回结果布尔值
     */
    public static boolean isMonotonic1(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int incr = 0, decr = 0;
        for (int i = 1; i < nums.length; i++) {
            incr += (nums[i-1] <= nums[i] ? 1 : 0);
            decr += (nums[i-1] >= nums[i] ? 1 : 0);
        }
        return (incr == nums.length - 1) || (decr == nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        System.out.println(isMonotonic(arr));
        System.out.println(isMonotonic1(arr));
    }

}
