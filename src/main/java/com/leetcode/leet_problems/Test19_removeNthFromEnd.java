package com.leetcode.leet_problems;

import com.leetcode.utils.ListNode;

public class Test19_removeNthFromEnd {

    /***
     * 遍历一遍得到链表的倒数第K个节点
     * 删除列表的倒数第K个节点
     * @param head 表示头结点
     * @param k  表示倒数第K
     * @return  返回新的链表
     */

    public static ListNode removeNthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode first = head;
        ListNode last = head;
        while (k > 0) {
            first = first.next;
            k--;
        }
        if (first == null) return head.next;
        while (first.next != null) {
            last = last.next;
            first = first.next;
        }
        if (last.next != null) last.next = last.next.next;
        return headNode.next;
    }
}
