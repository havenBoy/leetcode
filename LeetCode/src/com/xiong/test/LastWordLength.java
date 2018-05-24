package com.xiong.test;

import java.util.Arrays;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月19日 下午10:50:59
 * 类说明  给定一个字符串s由大写/小写字母和空白字符组成' '，返回字符串中最后一个单词的长度。
 * eg:输入： “Hello World”
 *    输出： 5
 */
public class LastWordLength {
	
	public static int lengthOfLastWord(String s) {
		return s.trim().length()- 1 - s.trim().lastIndexOf(" ");
	}
	
	/**
	 * 找出字符串的最大公共字符串
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		String res = strs[0];
 		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(res) != 0) 
				res = res.substring(0, res.length()-1); 
		}
 		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		Arrays.toString(nums);
		String[] str = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(str));
		String string = "  ss";
		System.out.println(lengthOfLastWord(string));
	}

}
