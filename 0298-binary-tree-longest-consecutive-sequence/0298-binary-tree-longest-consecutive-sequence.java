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
    private int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return maxLength;
    }
    private void dfs(TreeNode p, TreeNode parent, int length) {
        if(p == null) return;
        if(parent != null && (p.val == parent.val + 1)) {
            length += 1;
        } else {
            length = 1;
        }

        maxLength = Math.max(maxLength, length);

        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }
    
}