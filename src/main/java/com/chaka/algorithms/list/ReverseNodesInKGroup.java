package com.chaka.algorithms.list;

import com.chaka.algorithms.list.node.ListNode;

/**
 * K 个一组翻转链表
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1){
            return head;
        }

        int count = 0;
        ListNode curr = head;
        while (count != k && curr != null){
            curr = curr.next;
            count++;
        }

        if (count == k){
            curr = reverseKGroup(curr,k);
            while (count != 0){
                count--;
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;

        //先找出连续的k个节点

        //对这连续的k个节点进行翻转
    }

}