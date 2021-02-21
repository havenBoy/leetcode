package com.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * 找到第k个元素
 * @version 2.0.0
 * @author 赵小雄59782
 * @date 2020/11/30 10:34
 */
public class Test01 {

    /**
     * 链表结构定义
     */
    private static class ListNode {
        private int value;
        private ListNode next;

        private ListNode() {

        }

        public ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "->";
        }


    }

    /**
     * 查找倒数第K个数字
     */
    public static int findBackKNum(ListNode node, int k) {
        if(null == node || k == 0) {
            return -1;
        }
        ListNode first = null;
        ListNode second = node;
        for (int i = 0; i < k; i++) {
            if (null == node) {
                return -1;
            }
            node = node.next;
            if (k == i + 1) {
                first = node;
            }
        }

        while (null != first) {
            first = first.next;
            second = second.next;
        }

        return second.value;
    }

    public static void backPrint(ListNode node) {
        if(null == node) {
            return ;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (null != node) {
            stack.push(node);
            node = node.next;
        }

        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.toString());
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(findBackKNum(node1, 3));
        System.out.println(findBackKNum(node1, 10));
        backPrint(node1);


    }




}
