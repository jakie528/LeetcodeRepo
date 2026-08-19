/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // check the remaining nodes
        ListNode check = head;
        for(int i = 0; i < k; i++) {
            if(check == null) {
                return head;  // not reverse
            }
            check = check.next;
        }

        // start to reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 0; i < k; i++) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // prev is new head of the current group
        // right now curr is point to null
        // the head node become the tail node after k nodes reversed
        // curr 指向下一组节点的第一个节点

        // 将当前组的尾巴连上递归处理后的下一组的头节点
        if(curr != null) {
            head.next = reverseKGroup(curr, k);
        }

        return prev;
    }
}