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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case1
        if(p == null && q == null) return true;
        // base case2
        if(p == null || q == null) return false;

        if((p != null && q != null) &&  p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}