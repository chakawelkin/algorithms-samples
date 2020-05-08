package com.chaka.algorithms.list;

import com.chaka.algorithms.list.node.ListNode;

/**
 * 环形链表
 *  1、hash表 （时间复杂度为O(n)）
 *     {@code
 *     public boolean hasCycle(ListNode head) {
 *         Set<ListNode> set = new HashSet<>();
 *         while (head != null){
 *             if (set.contains(head)){
 *                 return true;
 *             }
 *             set.add(head);
 *             head = head.next;
 *         }
 *         return false;
 *     }}
 *  2、快慢指针 空间复杂度O(1)
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){return true;}
        }
        return false;
    }

}
