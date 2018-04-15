package com.xiong.test;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月15日 上午11:13:48
 * 类说明
 */
public class ListProblems {
	
	/***
	 * 删除链表中重复的数字
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)  return head;
        ListNode tail = head;
		while (tail.next != null) {
			if (tail.val == tail.next.val) {
				tail.next = tail.next.next;
			} else {
				tail = tail.next;
			}
		}
		return head;
	}
	
	/***
	 * 删除链表中目标值
	 * @param node
	 * @return
	 */
	public static ListNode delete1(ListNode node, int val) {
		if (node == null || node.next == null) return node;
		ListNode tail = node;
		while (tail.next != null) {
			if (tail.val == val) {
				tail.next = tail.next.next;
			} else {
				tail = tail.next;
			}
		}
		return node;
	}
	
	/***
	 * 反转链表
	 * @param node
	 * @return
	 */
	public static ListNode reverse(ListNode node) {
		return null;
	}
	
	/***
	 * 遍历一遍得到链表的倒数第K个节点
	 * @param node
	 * @return
	 */
	
	public static ListNode getK(ListNode node) {
		return null;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		ListNode.show(delete1(node1, 1));
		//ListNode.show(deleteDuplicates(node1));
	}

}
