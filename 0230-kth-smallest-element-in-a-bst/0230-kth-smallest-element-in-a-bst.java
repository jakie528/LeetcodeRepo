/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int i = 0;
        while (curr != null || !stack.isEmpty()) {

            // phase 1: go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // phase2: We hit null! Time to process nodes from the stack.
            curr = stack.pop(); // 1 pop up 
            i++;
            if (i == k) {
                return curr.val;
            }

            curr = curr.right;

        }

        return -1;

    }
}