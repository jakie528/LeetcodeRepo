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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(ListNode head : lists) {
            if(head != null)
            pq.add(head);
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        while(!pq.isEmpty()) {
            // poll the min node
            ListNode head = pq.poll();

            // Push the next node from the same list into the heap
            if(head.next != null) {
                pq.add(head.next);
            }

            prev.next = head;
            prev = head;
        }

        return dummyNode.next;

        
    }
}