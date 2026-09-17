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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;

        
        // within Bounds
        if(root != null && root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        
        if(root.val < low){ // all nodes in the left subtree are smaller than root.val, discard the current node and its left subtree
        return root.right = trimBST(root.right, low, high);
        } 
        
        if(root.val > high) {
            // all nodes in the right subtree are smaller than root.val, discard the current node and its right subtree
            return trimBST(root.left, low, high);
        }

        return root;
    }
}