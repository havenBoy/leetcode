package com.leetcode.leet_problems.Linkedlist;

import com.leetcode.utils.ListNode;

public class Test83_deleteDuplicates {

    /*
    给定一个已排序的链表的头 head
    删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
     */

    /**
     * @param head 给出一个链表
     * @return 返回去重后的链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        //首先记录下链表的起始节点
        ListNode node = head;
        while (head.next != null) {
            int value = head.val;
            //如果值相同，那么当前节点指向此节点下一节点的下一节点
            if (value == head.next.val) {
                head.next = head.next.next;
            } else {
                //如果值不同，那么当前节点向后走一个长度
                head = head.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode.show(deleteDuplicates(node1));
    }
}
