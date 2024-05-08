package com.leetcode.leet_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test26_removeDup {

    /*
      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次。
      必须原地删除，空间为O(1)
      不需要关心不重复后的数字
     */

    /**
     * 遍历一遍数组即可
     * 将每个数字放在一个list中，判断条件：不存在即放入
     * 将list中的每个值放置在数组的最前面，前面的下标取决于数组的大小
     * 这里借助了多余的内存，不属于解法
     * @param arr 目标数组
     * @return 返回新数组的大小
     */
    public static int removeDup(int[] arr) {
        int index = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                arr[index] = arr[i];
                list.add(arr[i]);
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] brr = new int[]{2,2,2,1,1,2,2,3,3,5};
        System.out.println(removeDup(brr));
        System.out.println(Arrays.toString(brr));
    }
}
