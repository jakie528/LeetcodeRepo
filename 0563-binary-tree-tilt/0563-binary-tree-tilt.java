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
    private int tilt;
    public int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }
    private int dfs(TreeNode node){
        if(node == null) {
            return 0;
        }
        
        int leftVal = dfs(node.left);

        int rightVal = dfs(node.right);

        tilt += Math.abs(leftVal - rightVal);

        return leftVal +rightVal +node.val;
    }
}