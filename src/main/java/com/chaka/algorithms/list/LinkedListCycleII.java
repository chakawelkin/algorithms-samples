package com.chaka.algorithms.list;

import com.chaka.algorithms.list.node.ListNode;

/**
 * 环形链表II
 *  给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *  1、hash
 *  2、快慢指针
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head== null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast= fast.next.next;
            if (slow == fast){
                break;
            }
        }

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}