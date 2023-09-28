package com.leetcode.leet_problems;

import com.leetcode.utils.ListNode;

import java.util.Stack;

public class Test206_reverseNode {

    /**
     * 头插法
     * 当前节点 cur
     * 末尾节点 last
     * 临时节点 tmp
     * @param head 给定头节点
     * @return 返回反转后的节点
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = head;
        ListNode cur = head.next;
        ListNode tmp;
        while (cur != null) {
            tmp = cur;
            cur = cur.next;
            tmp.next = head;
            head = tmp;
        }
        last.next = null;
        return head;
    }

    /**
     * 反转链表
     * 第一次遍历链表，将所有的数字push
     * 第二次遍历链表，将链表的值修改，返回头结点
     * 时间复杂度O(N) 空间复杂度为O(N)
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = head;
        ListNode node1 = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (node1 != null) {
            node1.val = stack.pop();
            node1 = node1.next;
        }
        return head;
    }

    /**
     * 使用三指针法
     * 先驱节点 pre
     * 当前节点 cur
     * 当前节点的下个节点 curNext
     * 时间复杂度O(N) 空间复杂度为O(1)
     * @param head 给定节点
     * @return 反转后的链表
     */
    public static ListNode reverse3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode curNext;
        ListNode newHead = null;
        while (cur != null) {
            curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return newHead;
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
        //ListNode.show(reverse(node1));
        //ListNode.show(reverse3(node1));
        //ListNode.show(reverse2(node1));
    }
}
