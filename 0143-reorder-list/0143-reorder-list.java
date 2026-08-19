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
        if(head == null) return;
        //find median: slow and fast pointer.
        // no dummy node
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // what slow point to is the median node
        // reverse the part
      
        ListNode prev = null;
        // store the head node
        ListNode curr = slow, tmp;


        while(curr != null) {
            // store the next node
            tmp = curr.next;
            curr.next = prev;
            // tmp.next = curr;
            prev = curr;
            curr = tmp;
        }

        // merge two Linkedlits
        ListNode first = head;
        ListNode second = prev;

        while(second.next != null) {
            tmp = first.next;
            first.next = second;
            // move the head pointer to the next node as well
            first = tmp;
            
            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}