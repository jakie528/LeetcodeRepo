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
        // two pointers in 0 and n-1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode L1 = dummy;
        ListNode L2 = dummy;


        int i = 0;

        // move the second pointer
        while(i < n) {
            L2 = L2.next;
            i++;
        }


        // move together
        while(L2 != null && L2.next != null) {
            L1 = L1.next;
            L2 = L2.next;
        }

        // L1 remove the next node
        if(L1 != null && L1.next != null) {
        L1.next = L1.next.next;
        }

        return dummy.next;
    }
}