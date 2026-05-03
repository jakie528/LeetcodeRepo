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
    private int max_sum;
    public int maxPathSum(TreeNode root) {
        // DFS - post-order traversal
       max_sum = Integer.MIN_VALUE;
        gainFromSubtree(root);

        return max_sum;
    }

    private int gainFromSubtree(TreeNode root){
        if(root == null) {
            return 0;
        }
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);
        max_sum = Math.max(max_sum, gainFromLeft + gainFromRight + root.val);

        return Math.max(gainFromLeft+ root.val, gainFromRight + root.val);
    }
}