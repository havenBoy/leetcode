package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月15日 上午11:13:48
 * 类说明
 */
public class ListProblems {
	
	/**
	 * 对K个链表排序
	 * @param lists
	 * @return
	 */
	public static com.xiong.test.ListNode mergeKLists(com.xiong.test.ListNode[] lists) {
		List<Integer> list = new ArrayList<>();
		for (com.xiong.test.ListNode listNode : lists) {
			while (listNode != null) {
				list.add(listNode.val);
				listNode = listNode.next;
			}
		}
		if(list.size() == 0) return null;
		Collections.sort(list);
		com.xiong.test.ListNode res = null;
		com.xiong.test.ListNode head = new com.xiong.test.ListNode(list.get(0));
		res = head;
		for (int i = 1; i < list.size(); i++) {
			head.next = new com.xiong.test.ListNode(list.get(i));
			head = head.next;
		}
		return res;
	}
	
	/**
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
       Output: 7 -> 0 -> 8
       Explanation: 342 + 465 = 807.
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static com.xiong.test.ListNode addTwoNumbers(com.xiong.test.ListNode l1, com.xiong.test.ListNode l2) {
        return combine(l1,l2,0);
    }
    
    public static com.xiong.test.ListNode combine(com.xiong.test.ListNode l1, com.xiong.test.ListNode l2, int flag) {
		if(l1 == null && l2 == null && flag == 0) return null;
		int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
		flag = sum >= 10 ? 1 : 0;
		int value = sum >= 10 ? sum-10 : sum;
		com.xiong.test.ListNode node = new com.xiong.test.ListNode(value);
		node.next = combine(l1 == null ? null : l1.next, l2==null ? null : l2.next, flag);
		return node;
	}
	
	/***
	 * 删除链表中重复的数字
	 * @param head
	 * @return
	 */
	public static com.xiong.test.ListNode deleteDuplicates(com.xiong.test.ListNode head) {
		if (head == null || head.next == null)  return head;
        com.xiong.test.ListNode tail = head;
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
	public static com.xiong.test.ListNode delete1(com.xiong.test.ListNode node, int val) {
		if (node == null || node.next == null) return node;
		com.xiong.test.ListNode tail = node;
		while (tail.next != null) {
			if (tail.val == val) {
				tail.next = tail.next.next;
			} else {
				tail = tail.next;
			}
		}
		return node;
	}
	
	/***  269
	 * 反转链表
	 * @param head
	 * @return
	 */
	public static com.xiong.test.ListNode reverse(com.xiong.test.ListNode head) {
		if(head == null || head.next == null) return head;
		com.xiong.test.ListNode p = head,newHead = null;
		while (p != null) {
			com.xiong.test.ListNode temp = p.next;
			p.next = newHead;
			newHead = p;
			p = temp;
		}
		return newHead;
	}
	
	/**
	 * 判断一个链表是否有环
	 * 2个指针，一个一次走一步，另外一个一次走2步
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(com.xiong.test.ListNode head) {
		if(head == null) return false;
		com.xiong.test.ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}
	
	/**
	 * 如果有环，返回环的起始节点 否则返回空
	 * 相遇时，一个节点赋值为起始节点，另外一个节点为相遇节点，下一次相遇的时候，
	 * 相遇的节点即为环的起始节点
	 * @param head
	 * @return
	 */
	public static com.xiong.test.ListNode markNode(com.xiong.test.ListNode head) {
		if(head == null) return null;
		com.xiong.test.ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				fast = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				} 
				return fast;
			}
		}
		return null;
	}
	
	/**
	 * 如果有环的话，返回环的长度
	 * 从相遇的节点开始再一次遍历，计算下次相遇时经过的长度
	 * @param head
	 * @return
	 */
	public static int cycleLength(com.xiong.test.ListNode head) {
		if(head == null) return 0;
		com.xiong.test.ListNode slow = head, fast = head;
		int count = 0;
		while(fast.next != null && fast.next.next == null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				while(fast.next != null && fast.next.next == null) {
					slow = slow.next;
					fast = fast.next.next;
					count++;
					if(slow == fast) break;
				}
				break;
			}
		}
		return count;
	}
	/**
	 * 在K位置处旋转列表
	 * @param head
	 * @param k
	 * @return
	 */
	public static com.xiong.test.ListNode rotate(com.xiong.test.ListNode head, int k) {
		if(head == null || k == 0) return head;
		int count = 1;
		com.xiong.test.ListNode p = head;
		while (p.next != null) {//遍历计算出列表的长度
			++count;
			p = p.next;
		}
		p.next = head;
		count = count - k % count;//去除k大于列表长度的情况
		for (int i = 0; i < count; i++) {
			p = p.next;
		}
		com.xiong.test.ListNode newHead = p.next;
		p.next = null;
		return newHead;
	}
	
	
	/***
	 * 遍历一遍得到链表的倒数第K个节点
	 * 删除列表的倒数第K个节点
	 * @param node
	 * @return
	 */
	
	public static com.xiong.test.ListNode getK(com.xiong.test.ListNode head, int k) {
		if(head == null || k <= 0)return head; 
		com.xiong.test.ListNode headNode = new com.xiong.test.ListNode(0);
		headNode.next = head;
		com.xiong.test.ListNode first = head;
		com.xiong.test.ListNode last = head;
		while(k > 0){
			first = first.next;
			k--;
		}
		if(first == null) return head.next;
		while(first != null && first.next != null){
			last = last.next;
			first = first.next;
		}
		if (last.next != null)  last.next = last.next.next;
		return headNode.next;
	}
	
	public static void main(String[] args) {
		com.xiong.test.ListNode node1 = new com.xiong.test.ListNode(1);
		com.xiong.test.ListNode node2 = new com.xiong.test.ListNode(5);
		com.xiong.test.ListNode node3 = new com.xiong.test.ListNode(3);
		com.xiong.test.ListNode node4 = new com.xiong.test.ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		com.xiong.test.ListNode node11 = new com.xiong.test.ListNode(1);
		com.xiong.test.ListNode node21 = new com.xiong.test.ListNode(5);
		com.xiong.test.ListNode node31 = new com.xiong.test.ListNode(3);
		com.xiong.test.ListNode node41 = new com.xiong.test.ListNode(4);
		node11.next = node21;
		node21.next = node31;
		node31.next = node41;
		node41.next = null;
		com.xiong.test.ListNode[] array = new com.xiong.test.ListNode[2];
		array[0] = node1;
		array[1] = node11;
		com.xiong.test.ListNode node = mergeKLists(array);
		com.xiong.test.ListNode.show(node);
		
		//ListNode.show(delete1(node1, 1));
		//ListNode.show(getK(node1, 4));
		//ListNode.show(deleteDuplicates(node1));
	}

}
