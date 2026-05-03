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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();
        nextLevel.offer(root);

        List<Integer> rightside = new ArrayList<>();

        TreeNode node = null;
        while(!nextLevel.isEmpty()) {
            currLevel = nextLevel;
            nextLevel = new ArrayDeque<>();

            while(!currLevel.isEmpty()) {
                node = currLevel.pop();

                if(node.left != null) {
                    nextLevel.offer(node.left);
                }
                if(node.right != null) {
                    nextLevel.offer(node.right);  // the tree from root or a subtree
                }
            }

            rightside.add(node.val); 

        }
        return rightside;

    }
}