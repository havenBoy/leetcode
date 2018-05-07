package com.xiong.test;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月15日 上午11:13:48
 * 类说明
 */
public class ListProblems {
	
	/**
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
       Output: 7 -> 0 -> 8
       Explanation: 342 + 465 = 807.
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return combine(l1,l2,0);
    }
    
    public static ListNode combine(ListNode l1, ListNode l2, int flag) {
		if(l1 == null && l2 == null && flag == 0) return null;
		int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
		flag = sum >= 10 ? 1 : 0;
		int value = sum >= 10 ? sum-10 : sum;
		ListNode node = new ListNode(value);
		node.next = combine(l1 == null ? null : l1.next, l2==null ? null : l2.next, flag);
		return node;
	}
	
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
	 * 删除列表的倒数第K个节点
	 * @param node
	 * @return
	 */
	
	public static ListNode getK(ListNode head, int k) {
		if(head == null || k <= 0)return head; 
		ListNode headNode = new ListNode(0);
		headNode.next = head;
		ListNode first = head;
		ListNode last = head;
		while(k > 0){
			first = first.next;
			k--;
		}
		while(first.next != null){
			last = last.next;
			first = first.next;
		}
		if (last.next != null)  last.next = last.next.next;
		return headNode.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		//ListNode.show(delete1(node1, 1));
		ListNode.show(getK(node1, 4));
		//ListNode.show(deleteDuplicates(node1));
	}

}
