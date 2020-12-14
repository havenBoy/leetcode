package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class RemoveElement {
	
	/**
	 * Given nums = [1,1,1,2,2],
	   Your function should return length = 2, 
	   with the first two elements of nums being 1 and 2 respectively.
	   It doesn't matter what you leave beyond the new length.
	   keep the order
	 * @param nums
	 * @return
	 */
	
	public static int removeElement(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int size = set.size();
			set.add(nums[i]);
			if (size != set.size()) {
				linkedList.add(nums[i]);
			}
		}
		for (int i = 0; i < set.size(); i++) {
			nums[i] = linkedList.get(i);
		}
		return set.size();
	}
	
	/***
	 * Given nums = [3,2,2,3], val = 3,
     * Your function should return length = 2, with the first two elements of nums being 2.
     * It doesn't matter what you leave beyond the returned length.
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int remove(int[] nums, int val) {
		if (nums.length == 0) return 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) nums[index++] = nums[i];
		}
		int[] array = new int[index+1];
		for (int i = 0; i < index; i++) array[i] = nums[i];
		return index;
	}
	/***
	 * 删除链表中重复的元素
	 * @param head
	 * @return
	 */
	public static ListNode removeDup(ListNode head) {
		if(head == null || head.next == null) { return head;}
		head.next = removeDup(head.next);
		return head.val == head.next.val ? head.next : head;
	}
	
	
	public static void main(String[] args) {
//		int[] num = {3,2,2,3};
//		System.out.println(remove(num, 3));
//		int[] nums = {1,1,1,2,2};
//		System.out.println(removeElement(nums));
	}

}
