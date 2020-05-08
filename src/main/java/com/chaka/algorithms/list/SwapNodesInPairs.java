package com.chaka.algorithms.list;

import com.chaka.algorithms.list.node.ListNode;

/**
 * 两两交换链表中的节点
 * 1、非递归法
 *      {@code
 *      public ListNode swapPairs(ListNode head) {
 *         ListNode pre = new ListNode(0);
 *         pre.next = head;
 *         ListNode tmp = pre;
 *         while (tmp.next != null && tmp.next.next != null) {
 *             ListNode start = tmp.next;
 *             ListNode end = tmp.next.next;
 *             tmp.next = end;
 *             start.next = end.next;
 *             end.next = start;
 *             tmp = start;
 *         }
 *         return pre.next;
 *     }}
 * 2、递归法 （代码很简介，但是并不会有带来什么性能上的提升）
 *     递归的关注点
 *     1、终止条件
 *     2、本级在做什么
 *     3、返回值
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
