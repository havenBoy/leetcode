package com.xiong.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] array) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<List<Integer>> listNew = new ArrayList<List<Integer>>();
		for (int i = 0; i < array.length-2; i++) {
			for (int j = i+1; j < array.length-1; j++) {
				for (int k = j+1; k < array.length; k++) {
					List<Integer> list = new ArrayList<>();
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
	public static void main(String[] args) {
		int[] array = {1,1,0,2,-2,-1};
//		List<List<Integer>> list = threeSum(array, 0);
//		show(list);
		List<List<Integer>> listNew = threeSum(array,0);
		show(listNew);
	}

}
