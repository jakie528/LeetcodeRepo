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

        // prev is the new head

        // curr is the head of a new group
        if(curr != null) {
            // use head.next to connect next group
            head.next = reverseKGroup(curr, k);
        }

        return prev;  
    }
}