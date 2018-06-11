package com.xiong.test;

public class Kmp {
	
	/**
	 * 暴力的匹配方法
	 * @param string
	 * @param substring
	 * @return
	 */
	public static int NotKmp(String string,String substring) {
		int str = string.length();
		int sub = substring.length();
		int i = 0, j = 0;
		while(i < str && j < sub) {
			if(string.charAt(i) == substring.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if(j == sub) return i-j;
		return -1;
	}
	/**
	 * 正式的KMP算法   理解next数组的含义
	 * @param string
	 * @param substring
	 * @param next
	 * @return
	 */
//	public static int Kmp(String string, String substring, int[] next) {
//		int str = string.length();
//		int sub = substring.length();
//		int i = 0, j = 0;
//	}
	
	public static void main(String[] args) {
		String string = "BBC ABCDAB ABCDABCDABDE", substring="ABCDABD";
		System.out.println(NotKmp(string, substring));
	}

}