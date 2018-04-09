package com.xiong.test;

import java.util.HashSet;
import java.util.Set;


/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月9日 下午10:39:26
 * 类说明
 */
public class RemoveElement {
	
	/**
	 * Given nums = [1,1,1,2,2],
	   Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
	   It doesn't matter what you leave beyond the new length.
	 * @param nums
	 * @return
	 */
	
	//不重复的数组中的数字的个数  但结果不能返回正常的数组
	public static int removeElement(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		return set.size();
	}
	
	
	
	public static void main(String[] args) {
		
		int[] nums = {1,1,1,2,2};
		System.out.println(removeElement(nums));
	}

}
