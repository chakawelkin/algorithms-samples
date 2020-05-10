package com.chaka.algorithms.list;

import com.chaka.algorithms.list.node.ListNode;

/**
 * 合并两个有序链表
 *  1、迭代法
 * {@code
 * public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 *         if (l1 == null){
 *             return l2;
 *         }
 *         if (l2 == null){
 *             return l1;
 *         }
 *         ListNode start = new ListNode(0);
 *         ListNode head;
 *         ListNode next;
 *         if (l1.val < l2.val){
 *             head = l1;
 *             next = l2;
 *         }else {
 *             head = l2;
 *             next = l1;
 *         }
 *         start.next = head;
 *
 *         while (true){
 *             // 基础链表遍历完成
 *             if (head.next == null){
 *                 head.next = next;
 *                 break;
 *             }
 *             if (head.val <= next.val && next.val < head.next.val){
 *                 ListNode tmp = head.next;
 *                 head.next = next;
 *                 next = next.next;
 *                 head.next.next = tmp;
 *                 head = head.next;
 *                 if (next == null){break;}
 *             }else {
 *                 head = head.next;
 *             }
 *         }
 *
 *         return start.next;
 *
 *     }}
 *  2、递归法
 *      1)终止条件 l1或l2为null
 *      2）返回值 返回排序好链表的头
 *      3）简单一句话就是排序，找到更小的节点，哪个值更小就使用哪个值的next节点指向排好序的链表
 *
 */
public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
