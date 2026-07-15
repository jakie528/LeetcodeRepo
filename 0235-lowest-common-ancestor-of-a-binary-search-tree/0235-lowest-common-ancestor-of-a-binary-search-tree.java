/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;

        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        // we have found the split point, i.e. the LCA node
        return root;




        
    }


}