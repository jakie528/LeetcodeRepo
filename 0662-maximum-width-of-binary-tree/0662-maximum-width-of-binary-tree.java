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

    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // enque the root node with position 0
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int maxWidth = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            // find leftPos
            int leftpos = queue.peek().index;
            int rightPos = leftpos;

            for(int i = 0; i < levelSize; i++) {
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                int pos = curr.index;

                // update rightPos to the position of rightmost node
                // if(i == levelSize -1 ){
                    rightPos = pos;
                // }

                if(node.left != null) {
                    queue.offer(new Pair(node.left, 2*pos +1));
                }
                if(node.right != null) {
                    queue.offer(new Pair(node.right, 2 * pos+2));
                }
            }
            // current level max
            maxWidth = Math.max(rightPos - leftpos +1, maxWidth);
        }
        return maxWidth;
}
}