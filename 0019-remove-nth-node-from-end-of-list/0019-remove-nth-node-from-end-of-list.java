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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // advance first pointer ahead
        for(int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // maintain the gap
        while(first != null) {
            first = first.next;
            second = second.next;
        }

        // delete the node
        second.next = second.next.next;

        return dummy.next;
    }
}