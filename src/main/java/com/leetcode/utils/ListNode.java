package com.leetcode.utils;

/**
 * 链表工具类
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月15日 上午11:08:57
 * 类说明
 */
public class ListNode {
	
	public int val;

    public ListNode next;

    public ListNode(int x) { this.val = x; }
    
    /***
     * 遍历打印列表
     * @param node 头节点
     */
    public static void show(ListNode node) {
    	if (node == null) return ;
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.print("null");
	}

}
