package com.chaka.algorithms.list.node;

/**
 * 单向链表节点
 */
public class ListNode {

    int val;

    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}