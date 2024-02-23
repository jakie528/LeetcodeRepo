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
    public boolean isValidBST(TreeNode root) {
        //null represent no value
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null) {
            return true;
        }

       // the current root must between low and high
        if((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        //the lowest value is the root's value in the right subtree
        //the highest value is the root's value in the left subtree
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }
}