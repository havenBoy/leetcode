package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	
	//DFS经典解决问题办法
	
	/**  46. Permutations 
	 * 全排列问题(无重复数字)
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length == 0) return null;
        dfs(res, nums, 0, nums.length);
        return res;
    }
    
    
    /** 47. Permutations 2
	 * 全排列问题(有重复数字)
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permutes(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length == 0) return null;
        dfs(res, nums, 0, nums.length);
        return res;
    }
    
    public static void dfs(List<List<Integer>> res, int[] nums, int i, int len) {
		if (i == len-1) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < nums.length; j++) {
				list.add(nums[j]);
			}
			res.add(list);
			return ;
		}
		for(int j = i; j < len; j++) {
			swap(nums, i, j);
			dfs(res, nums, i+1, len);
			swap(nums, i, j);
		}
	}
    
	
	//交换元素
	public static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
