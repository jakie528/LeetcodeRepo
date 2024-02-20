/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //set up a false "prehead" node that allows us to easily return the
//head of the merged list later
        ListNode prehead = new ListNode(-1);
// maintain a prev pointer
        ListNode prev = prehead;

        while(list1!= null && list2!= null) {
            if(list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            //regardless of which list we connected, we
//increment prev to keep it one step behind one of our list heads.
            prev = prev.next; 
        }
        // at least one of node either in L1 or L2 not being merged
        prev.next = (list1 == null? list2 : list1);

        return prehead.next; // just from the head of the merge list

    }

    // Time complexity : O(n+m)O(n + m)O(n+m)

// Because exactly one of l1 and l2 is incremented on each loop
// iteration, the while loop runs for a number of iterations equal to the
// sum of the lengths of the two lists. All other work is constant, so the
// overall complexity is linear.

// Space complexity : O(1)

// The iterative approach only allocates a few pointers, so it has a
// constant overall memory footprint.
}