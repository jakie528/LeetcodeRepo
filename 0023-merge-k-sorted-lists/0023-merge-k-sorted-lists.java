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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val-b.val);
        // a dummy node
        LinkedList<ListNode> finalList = new LinkedList<>();
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;


        // insert the head node of k linked-lists into the Min-heap
        for(ListNode head : lists) {
            if(head != null) {
               queue.add(head);
            }
        }

        while(!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            // attch the minNode to the end of cour build
            curr.next = minNode;
            // move the curr pointer forward
            curr = curr.next;
            
            // advancing the pointer for that specific linkedlist
            if(minNode.next != null) {
                queue.add(minNode.next);
            }
        }

        return dummy.next;

        


        
    }
}