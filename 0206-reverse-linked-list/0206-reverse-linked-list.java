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
    public ListNode reverseList(ListNode head) {
        // store the prev node
        ListNode node = null;
        ListNode prev = node;

        // store the current node
        ListNode curr = head;

        while(curr!= null) {
         //store the next node 
        ListNode next = curr.next;

        // current node point to prev node
        curr.next = prev;
        // move the prev / curr pointer to the next node
        prev = curr;
        curr = next;

        }

        return prev;
    }
}