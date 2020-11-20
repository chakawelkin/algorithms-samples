package hot100;

import com.chaka.algorithms.list.node.ListNode;

/**
 * 两数相加
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return dfs(l1,l2,0);
    }

    public ListNode dfs(ListNode l1, ListNode l2,int num){
        if (l1 == null && l2 == null) {
            return num > 0 ? new ListNode(num) : null;
        }
        //计算两数之和
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + num;
        ListNode node = new ListNode(sum % 10);
        node.next = dfs(l1 == null ? null : l1.next,l2 == null ? null : l2.next,sum / 10);
        return node;
    }

}
