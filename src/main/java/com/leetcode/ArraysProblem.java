package com.leetcode;

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


    public static void main(String[] args) {

        System.out.println(2 >> 1);

        System.out.println(2 & 1);
    }
}
