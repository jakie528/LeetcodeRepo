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
    public boolean isPalindrome(ListNode head) {
        // convert the original linkedlist to a list.
        List<Integer> vals = new ArrayList<>();
        ListNode currNode = head;
        while(currNode != null) {
            vals.add(currNode.val);
            currNode = currNode.next;
        }

        // Compare the list with its reverse
        List<Integer> reverse = new ArrayList<>(vals);
        // In-Place modification
        Collections.reverse(reverse);

        return vals.equals(reverse);
    }
}