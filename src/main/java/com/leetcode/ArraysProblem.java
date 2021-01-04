package com.leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 单纯数组问题收集
 */
public class ArraysProblem {

    /**
     * 数组的最后一个数字的"加法"
     * 需要判断是否所有数字都为9
     * @param numbs 传入的参数
     * @return 返回数组
     */
    public static int[] plusOne_1(int[] numbs) {
        int index = numbs.length-1;
        while(index >= 0) {
            int temp = numbs[index];
            if (numbs[index] != 9) {
                numbs[index] = temp + 1;
                break;
            } else {
                numbs[index] = 0;
                if (index == 0) {
                    int[] array = new int[numbs.length+1];
                    array[0] = 1;
                    return array;
                }
                index--;
            }
        }
        return numbs;
    }
    public static int[] plusOne_2(int[] arr) {
        int length = arr.length;
        boolean flag = true;
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] == 9) {
                arr[i] = 0;
            } else {
                arr[i] = arr[i] + 1;
                flag = false;
                break;
            }
        }
        if (flag) {
            arr = new int[length + 1];
            arr[0] = 1;
        }
        return arr;
    }

    /**
     * 寻找一个数组中前K小个数字
     * @param arr
     * @param k
     * @return
     */
    public static int[] findMinKNum(int[] arr, int k) {
        int length = arr.length;
        if (length <= k) {
            return arr;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < length; i++) {
            if (i < k) {
                set.add(arr[i]);
                continue;
            }
            int min = set.last();
            if (min > arr[i]) {
                set.remove(min);
                set.add(arr[i]);
            }
        }
        int[] result = new int[k];
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            result[--k] = num;
        }
        return result;
    }

    public static int[] findMinKNum_1(int[] arr, int k) {
        int length = arr.length;
        if (k >= length) {
            return arr;
        }
        for (int i = 0; i < k; i++) {
            int num = arr[i];
            for (int j = k + 1; j < length; j++) {
                if (arr[j] > num) {
                    arr[i] = arr[j];
                    arr[j] = num;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        System.out.println(2 >> 1);
        System.out.println(2 & 1);

        int[] arr = {10, 4, 7, 9, 8, 8};
        Utils.show(findMinKNum(arr, 3));
        System.out.println("----------");
        Utils.show(findMinKNum_1(arr, 3));
    }
}
