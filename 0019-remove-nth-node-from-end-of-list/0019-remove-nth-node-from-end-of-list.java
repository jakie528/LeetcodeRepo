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
        ListNode prev = dummy;
        prev.next = head;

        int count = 0;
        // calculate the nodes
        while(head != null) {
            head = head.next;
            count++;
        }

        int targetIndex = count - n; //  3-3 = 0
        int currCount = 0;

        // [1,2,3]
        while(prev != null && prev.next != null) {
            // check before moving
            if(currCount == targetIndex) { // 
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
            currCount++;
        }

        return dummy.next;
    }
}