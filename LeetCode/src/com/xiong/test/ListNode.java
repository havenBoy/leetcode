package com.xiong.test;
/**
 * 链表工具类
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月15日 上午11:08:57
 * 类说明
 */
public class ListNode {
	
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    /***
     * 遍历打印列表
     * @param node
     */
    public static void show(ListNode node) {
    	if (node == null) return ;
		while (node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
	}

}
