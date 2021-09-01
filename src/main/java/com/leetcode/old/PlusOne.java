package com.leetcode.old;

/**
 * 题目2：实现字符串的二进制加法  “111” + “11” = “1010”
 * 题目3：不使用+ -运算，计算2数字之和
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月18日 下午10:26:19
 */
public class PlusOne {
	
	/**
	 * 计算2数之和
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sum(int a, int b) {
		if(a == 0) return b;
		int x = a ^ b;
		int c = (a & b) << 1;
		return sum(c, x);
	}
	/**
	 * 字符串的二进制加法
	 * @param a
	 * @param b
	 * @return
	 */
	public static String binaryPlus(String a, String b) {
		int aLen = a.length()-1, bLen = b.length()-1;
		int cLen = aLen > bLen ? aLen : bLen;
		StringBuilder result = new StringBuilder();
		int[] array = new int[cLen+2];
		int arrayIndex = 0;
		int flag = 0;
		if (aLen >= 0 || bLen >= 0) {
			int aa = Integer.parseInt(String.valueOf(a.charAt(aLen)));
			int bb = Integer.parseInt(String.valueOf(b.charAt(bLen)));
			if (aLen < 0) {
				aa = 0;
			} else if (bLen < 0){
				bb = 0;
			}
			int index = aa ^ bb ^ flag;
			if(aa + bb + flag >= 2) flag = 1;
			array[arrayIndex] = index;
			arrayIndex++;
			if (flag == 1 && arrayIndex == array.length-1) array[array.length-1] = 1;
			aLen--;
			bLen--;
		}
		for (int i = 0; i < array.length; i++) {
			result.append(array[i]);
		}
		return result.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(binaryPlus("111", "1"));
		System.out.println(sum(1, 2));
	}

}
