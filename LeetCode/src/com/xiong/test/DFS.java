package com.xiong.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DFS {
	
	//DFS经典解决问题办法
	
	/**
	 * 全排列问题
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length == 0) return null;
        dfs(res, nums, 0, nums.length);
        return res;
    }
    
    public static void dfs(List<List<Integer>> res, int[] nums, int i, int len) {
		if (i == len-1) {
			List<Integer> list = new ArrayList<>();
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
	
	
	//测试
	@Test
	public void test() {
		int[] nums = {1};
		System.out.println(permute(nums).size());
	}

}
