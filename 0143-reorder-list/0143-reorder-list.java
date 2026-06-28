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
    public void reorderList(ListNode head) {
        // two pointer
        ListNode prevHead = new ListNode(-1);

        prevHead.next = head;

        // find the middle node
        ListNode slow = head;
        ListNode fast = head;


        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second part of the list
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp;

        while(curr != null) {
            temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        // merged two lists
        ListNode first = head;
        ListNode second = prev;

        while(second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second =temp;
        }




    }
}