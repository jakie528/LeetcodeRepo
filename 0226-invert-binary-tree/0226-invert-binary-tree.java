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
    // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
// 利用函数定义，先翻转左右子树
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        // 然后交换左右子节点
        root.left = right;
        root.right = left;
// 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }
}
//the time complexity is : O(n)
//the space complexity: O(h).