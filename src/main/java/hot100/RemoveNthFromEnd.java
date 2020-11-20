package hot100;

import com.chaka.algorithms.list.node.ListNode;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {

    private int count;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)){
            return null;
        }
        ListNode node = removeNthFromEnd(head.next,n);
        count++;
        if (count == n){
            head.next = node == null ? null : node.next;
        }else {
            head.next = node;
        }
        return head;
    }

}
