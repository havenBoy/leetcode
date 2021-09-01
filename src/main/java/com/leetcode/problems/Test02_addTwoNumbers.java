package com.leetcode.problems;

import com.leetcode.utils.ListNode;

public class Test02_addTwoNumbers {

    /*
     * 题目描述
     * 给你两个 非空 的链表，表示两个非负的整数。
     * 它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     */

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 返回结果链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return combine(l1, l2, 0);
    }

    public static ListNode combine(ListNode l1, ListNode l2, int flag) {
        if (l1 == null && l2 == null && flag == 0) return null;
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
        flag = sum >= 10 ? 1 : 0;
        int value = sum >= 10 ? sum - 10 : sum;
        ListNode node = new ListNode(value);
        node.next = combine(l1 == null ? null : l1.next, l2 == null ? null : l2.next, flag);
        return node;
    }

}