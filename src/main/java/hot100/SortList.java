package hot100;

import com.chaka.algorithms.list.node.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        return sort(head,null);
    }

    private ListNode sort(ListNode head, ListNode tail){
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode sort_1 = sort(head,slow);
        ListNode sort_2 = sort(slow,tail);
        return merge(sort_1,sort_2);
    }

    private ListNode merge(ListNode sort_1, ListNode sort_2){
        ListNode temp = new ListNode(0);
        ListNode pre = temp;
        while (sort_1 != null && sort_2 != null){
            if(sort_1.val > sort_2.val){
                pre.next = sort_2;
                sort_2 = sort_2.next;
            }else {
                pre.next = sort_1;
                sort_1 = sort_1.next;
            }
            pre = pre.next;
        }

        if (sort_1 != null){
            pre.next = sort_1;
        }

        if (sort_2 != null){
            pre.next = sort_2;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(4);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(1);
        ListNode four = new ListNode(3);
        one.next = two;
        two.next = three;
        three.next = four;
        SortList sortList = new SortList();
        sortList.sortList(one);
    }

}