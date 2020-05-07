package com.chaka.algorithms.list;

/**
 * 链表的反转
 *  1、双指针迭代
 *      前驱指针，当前指针
 *      {@code
 *      public ListNode reverseList(ListNode head) {
 *         ListNode pre = null;
 *         ListNode curr = head;
 *         ListNode tmp = null;
 *         while (curr != null){
 *             tmp = curr.next;
 *             curr.next = pre;
 *             pre = curr;
 *             curr = tmp;
 *         }
 *         return pre;
 *     }}
 *  2、递归解法
 */
public class ReverseLinkedList {

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null){
           return head;
       }
       ListNode curr = reverseList(head.next);
       //此时curr为最后一个节点
       head.next.next = head;
       head.next = null;
       return curr;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}