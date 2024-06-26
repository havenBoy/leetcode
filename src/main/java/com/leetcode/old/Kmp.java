package com.leetcode.old;

public class Kmp {
	
	/**
	 * 暴力的匹配方法 (Implement strStr() 问题解决)
	 * @param haystack  主体字符串
	 * @param needle  待匹配字符串
	 * @return 返回起始下标值
	 */
	public static int NotKmp(String haystack, String needle) {
		int str = haystack.length();
		int sub = needle.length();
		int i = 0, j = 0;
		while(i < str && j < sub) {
			if(haystack.charAt(i) == needle.charAt(j)) {
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
	 * @param string 主体字符串
	 * @param substring 待匹配字符串
	 * @param next 下个数组 TODO
	 * @return 返回下标
	 */
	public static int Kmp(String string, String substring, int[] next) {
		int str = string.length();
		int sub = substring.length();
		int i = 0, j = 0;
		return 0;
	}
	
	public static void main(String[] args) {
		String string = "BBC ABCDAB ABCDABCDABDE", substring="ABCDABD";
		System.out.println(NotKmp(string, substring));
	}

}
