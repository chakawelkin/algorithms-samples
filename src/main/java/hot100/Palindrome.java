package hot100;

import com.chaka.algorithms.list.node.ListNode;

/**
 * @author chaka.hu
 * @date 2021/3/9 11:00 下午
 */
public class Palindrome {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);

        while (slow != null){
            if (head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while (node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        Palindrome solve = new Palindrome();
        System.out.println(solve.isPalindrome(node));
    }

}
