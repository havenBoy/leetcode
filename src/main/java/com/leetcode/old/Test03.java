package com.leetcode.old;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 二分法查找以及延伸：双指针法
 * @version 2.0.0
 * @author zxx
 * @date 2020/11/30 12:00
 */
public class Test03 {

    /*** 
     * 二分法查找有序数组
     *
     * @author zxx
     * @date 2020/11/30 20:50
     * @param arr 数组
     * @param num 目标数字
     * @return  返回下标索引值
     */
    public static int findNum(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int medium = (start + end) / 2;
            if (num == arr[medium]) {
                return medium;
            }
            if(num > arr[medium]) {
                start = medium + 1;
            }
            if(num < arr[medium]) {
                end = medium - 1;
            }
        }
        return -1;
    }


    /***
     * 剑指OFFER：
     * 查询有序二维数组中是否存在某个数值
     *
     * @author zxx
     * @date 2020/11/30 20:54
     * @param nums 二维数组
     * @return  true或者false
     */
    public static boolean findNum(int[][] nums) {
        return false;
    }

    /**
     * 判断一个数字是否为回文数字
     * @param num  传入数字
     * @return 返回是否为回文数字
     */
    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        String numStr = String.valueOf(num);
        if (numStr.length() == 1) {
            return true;
        }
        int start = 0;
        int end = numStr.length() - 1;
        while (start < end) {
            if (numStr.charAt(start) == numStr.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 最大区域面积  二分策略调整
     * 思路：首先尝试获取到最大的长，可以获取到当前长度下的面积
     * 要获取到更大的面积，需要试着调整长，调整长的策略：
     * 保留当前最大的高，移动较小值的下标重新计算面积大小。
     * @param height  输入的数组
     * @return 返回最大面积数字
     */
    public static int maxArea(int[] height) {
        int length = height.length;
        int start = 0, end = length - 1;
        int result = 0;
        while (start < end) {
            int startNum = height[start];
            int endNum = height[end];
            result = Math.max(result, (end - start) * Math.min(startNum, endNum));
            if (startNum >= endNum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }

    /**
     * 无重复字符的最长字符串
     * @param str  传入字符串
     * @return 返回是否为回文数字
     */
    public static int lengthOfLongestSubstring(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<Character>();
            set.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                Character character = str.charAt(j);
                if (set.contains(character)) {
                    break;
                } else {
                    set.add(character);
                }
            }
            result = Math.max(result, set.size());
        }
        return result;
    }

    /*** 
     * 剑指OFFER：21
     * 数组归类，左边奇数右边偶数
     *
     * @author zxx
     * @date 2020/11/30 20:51
     * @param num  输入数组
     * @return void
     */
    public static void groupNum(int[] num) {
        if (null == num || num.length == 1) {
            return;
        }
        int start = 0;
        int end = num.length - 1;
        while (start < end) {

            while (start < end && num[start] % 2 != 0) {
                start++;
            }
            while (start < end && num[end] % 2 == 0) {
                end--;
            }

            // swap
            int tmp = num[start];
            num[start] = num[end];
            num[end] = tmp;
        }
    }

    /**
     * LeetCode:
     * 27.移除目标元素
     * 将数组中非目标元素移动到数组的前方
     * 思路：双指针法
     * array  数组
     * target 目标数字
     * @return
     */

    public static int removeElement(int[] array, int target) {
        int start = 0;
        for (int end = 0; end < array.length; end++) {
            if (target != array[end]) {
                array[start] = array[end];
                start++;
            }
        }
        return start;
    }

    /**
     * LeetCode:
     * 26.移除重复元素
     * 将排序数组中重复的元素删除，使得元素只出现一次,返回数组最终长度
     * 思路：双指针法
     * @param array  数组
     * @return int 数组最终长度
     */

    public static int removeDuplicates(int[] array) {
        if (null == array || array.length <= 1) {
            return null == array ? 0 : array.length;
        }
        int start = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
                continue;
            } else {
                array[start] = array[i];
                start++;
                list.add(array[i]);
            }
        }
        return start;
    }


    /**
     * 打印数组工具类
     * @param num  输入数组
     */
    public static void print(int[] num) {
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "->");
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,1,2};
        //findNum(arr, 5);
        //groupNum(arr);
        System.out.println(removeDuplicates(arr));
        print(arr);

        System.out.println(isPalindrome(121));

        String str = "abcabcbb";
        String str1 = "  ";
        System.out.println(lengthOfLongestSubstring(str1));

        //int[] nums = {1,8,6,2,5,4,8,3,7};

        int[] nums = {1};
        System.out.println(maxArea(nums));
    }
}
