package com.leetcode.old;

import java.util.*;

/**
 * 动态规划思想
 * @author Xiong
 *
 */
public class ThreeSum {
	
	private static String[] stringMap = {
		" ",
		"",
		"abc",
		"def",
		"ghi",
		"jkl",
		"mno",
		"pqrs",
		"tuv",
		"wxyz",
	};
	
	
	public static void subletter(List<String> list, String digits, int index, String s) {
		if(digits.length() == 0) return ;
		if(digits.length() == index) {
			list.add(s);
			return ;
		}
		char c = digits.charAt(index);
		if( c > '0' && c < '9' && c != '1') {
			String letters = stringMap[c - '0'];
			for (int i = 0; i < letters.length(); i++) {
				subletter(list, digits, index+1, s + letters.charAt(i));
			}
		}
	}
	
	
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		subletter(res, digits, 0, "");
		return res;
	}
	
	/**
	 * 返回所有组合为目标值的集合（给定数组无重复元素，且要求返回集合无重复）
	 * @param candidates
	 * @param target
	 * @return
	 */
//	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//	}
 
	/**
	 * 返回所有组合为目标值的集合（给定数组有重复元素，且要求返回集合中无重复元素）
	 * @param candidates
	 * @param target
	 * @return
	 */
//    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        
//    }
	
	
	/**
	 * 给定数组和一个目标值，找出3个数字之和等于目标值
	 * @param array
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] array) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<List<Integer>> listNew = new ArrayList<List<Integer>>();
		for (int i = 0; i < array.length-2; i++) {
			for (int j = i+1; j < array.length-1; j++) {
				for (int k = j+1; k < array.length; k++) {
					List<Integer> list = new ArrayList<Integer>();
					if (array[k] + array[j] + array[i] == 0) {
						list.add(array[i]);
						list.add(array[j]);
						list.add(array[k]);
						set.add(list);
					}
				}
			}
		}
		for (List<Integer> listEach : set) {
			listNew.add(listEach);
		}
		return listNew;
	}
	
	public static List<List<Integer>> threeSum(int[] nums, int target) {
		if(nums.length < 3) return new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> resList = twoSum(nums,target-nums[i],i);
			if(resList.size() != 0 && !list.contains(resList)) list.add(resList);
		}
		return list;
	}
	
	/**
	 * 给定数组和一个目标值，找出2个数字之和等于目标值
	 * @param array
	 * @return
	 */
	public static List<Integer> twoSum(int[] nums,int target, int index) {
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length && i != index; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length && i != index; i++) {
			if (map.containsKey(target-nums[i])) {
				if (map.get((target-nums[i])) != index &&
						map.get(nums[index]) != map.get(target-nums[i]) && 
						map.get(nums[i]) != map.get(target-nums[i])) {
					list.add(nums[index]);
					list.add(nums[i]);
					list.add(target-nums[i]);
					break;
				}
			}
		}
		return list;
	}
	
	public static void showList(List<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	public static void shows (Set<List<Integer>> set) {
		for (List<Integer> list : set) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + ";");
			}
			System.out.println("");
		}
	}
	
	public static void show(List<List<Integer>> list) {
		for (List<Integer> list2 : list) {
			for (int i = 0; i < list2.size(); i++) {
				System.out.print(list2.get(i) + ";");
			}
			System.out.println("");
		}
	}

}
