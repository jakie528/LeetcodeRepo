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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                prev = prev.next;
                list1 = list1.next;
            } else {
                prev.next = list2;
                prev = prev.next;
                list2 = list2.next;
            }
        }

        // the left node would be greater than the node we return
        if (list1 == null) {
            prev.next = list2;
        } else {
            prev.next = list1;
        }

        return preHead.next;
    }
}