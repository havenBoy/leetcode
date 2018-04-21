package com.xiong.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月21日 下午10:37:12
 * 类说明   2个数组的交集  （set的唯一性依次set）
 * 以及2个数组的并集（set的唯一性以此set）
 */
public class InterSectionArrays {
	
	public static int[] interSection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			list1.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			list2.add(nums2[i]);
		}
		if (list1.size() < list2.size()) {
			for (int i = 0; i < nums1.length; i++) {
				if (list2.contains(list1.get(i))) {
					set.add(list1.get(i));
				}
			}
		} else {
			for (int i = 0; i < nums2.length; i++) {
				if (list1.contains(list2.get(i))) {
					set.add(list2.get(i));
				}
			}
		}
		int[] nums = new int[set.size()];
		int index = 0;
		for (Integer integer : set) {
			nums[index++] = integer;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		Utils.show(interSection(nums1, nums2));
	}

}
