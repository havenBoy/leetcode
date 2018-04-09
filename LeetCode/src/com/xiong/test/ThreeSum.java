package com.xiong.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	/**
	 * 找出一个给定数组中，任意三个数字之和等于目标值0 （可扩展为任意值），返回所有子集的集合
	 */
	
	//此种解决办法只是时间效率最低的，运算时间可能会超出规定的时间
	public static List<List<Integer>> threeSum(int[] array) {
		//先排序可以有效的去除相同的数组，不针对数组的顺序
		Arrays.sort(array);
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
	//用于现实出找到结果集显示
	public static void show(List<List<Integer>> list) {
		for (List<Integer> list2 : list) {
			for (int i = 0; i < list2.size(); i++) {
				System.out.print(list2.get(i) + ";");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		int[] array = {-4,-1,-1,0,1,1,1,2};
		List<List<Integer>> listNew = threeSum(array);
		show(listNew);
	}

}
