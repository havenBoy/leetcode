package com.xiong.test;

/**
 * 题目1：对数组中的最后一位进行加1的运算 [1,2,3,4]->[1,2,3,5]
 * 题目2：
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月18日 下午10:26:19
 * 类说明
 */
public class PlusOne {
	
	public static String binaryPlus(String a, String b) {
		int aLen = a.length()-1, bLen = b.length()-1;
		int cLen = aLen > bLen ? aLen : bLen;
		int[] array = new int[cLen];
		if (aLen >= 0 || bLen >= 0) {
			int aa = Integer.parseInt(String.valueOf(a.charAt(aLen)));
			int bb = Integer.parseInt(String.valueOf(b.charAt(bLen)));
			if (aLen < 0) {
				aa = 0;
			} else {
				bb = 0;
			}
			array[cLen--] = aa ^ bb;
			aLen--;
			bLen--;
		}
		return array.toString();
	}
	
	public static int[] plusOne(int[] nums) {
		int index = nums.length-1;
		while(index >= 0) {
			int temp = nums[index];
			if (nums[index] != 9) {
				nums[index] = temp + 1;
				break;
			} else {
				nums[index] = 0;
				if (index == 0) {
					int[] array = new int[nums.length+1];
					array[0] = 1;
					return array;
				}
				index--;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		System.out.println(String.valueOf("1"));
		int[] nums = {9,9,9};
		System.out.println(nums.toString());
		Utils.show(plusOne(nums));
	}

}
