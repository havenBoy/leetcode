package com.leetcode.leet_problems;

import com.leetcode.utils.ListNode;

public class Test82_deleteDuplicates2 {

    /*
    给定一个已排序的链表的头 head
    删除所有重复的元素，使得链表中只存在不重复的数字的列表
     */

    /**
     * @param head 给出一个链表
     * @return 返回去重后的链表
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        ListNode init = new ListNode(0);
        init.next = head;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int value2 = head.next.val;
                while (head.next != null && value2 == head.next.val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return init.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //维护一个不变的结点guard
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode pre = guard;
        ListNode cur = head;
        while (cur != null) {
            //如果出现重复的情况如下
            //相等的结点则跳过,走到相同值元素的最后一步
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            //如果pre和cur之间没有重复节点，pre后移
            if (pre.next == cur) {
                pre = pre.next;
            }
            //将cur的前指针向后移动一位
            else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return guard.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //ListNode.show(deleteDuplicates(node1));
        ListNode.show(deleteDuplicates2(node1));
    }
}
