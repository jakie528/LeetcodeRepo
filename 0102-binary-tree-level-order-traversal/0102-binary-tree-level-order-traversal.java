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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) { // 1
                TreeNode node = queue.poll(); //node = 3
                currentLevel.add(node.val);  //3

                if (node.left != null) {
                    queue.add(node.left); // 9
                }
                if (node.right != null) {
                    queue.add(node.right);  //20
                }
            }
            res.add(currentLevel); // 3
        }

        return res;

    }
}