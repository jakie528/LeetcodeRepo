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
        LinkedList<TreeNode> stack = new LinkedList<>();

        while(true) {
            while(root != null) {
            stack.push(root);
            root = root.left;
            }
        
        root = stack.pop();
        // k decrement by 1 then compare with 0
        if(--k == 0) 
        return root.val;
        //to right tree
        root = root.right;
        }
    }
}