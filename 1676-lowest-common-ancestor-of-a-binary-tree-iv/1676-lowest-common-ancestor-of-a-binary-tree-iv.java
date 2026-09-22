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
    private Set<TreeNode> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // use set so we don't need to go further.
        // O(1)
        for(TreeNode node : nodes) {
            set.add(node);
        }
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root){
        // if node in the set, we just return and not go to the childs
        if(root == null || set.contains(root)) {
            return root;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }

        // if l and r not null
            return root;
}
}

// T: O(N)convert the nodes to the hashset + O(N)traverse the binary tree -> O(2N) 
// S: Set store O(N) and recursion O(N)