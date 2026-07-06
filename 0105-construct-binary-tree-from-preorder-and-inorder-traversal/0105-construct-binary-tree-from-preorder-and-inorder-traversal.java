

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
    int preorderIndex = 0;
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder: get the root the the Tree from preorder
        // inorder: the array on the left side of the root is left subtree
        // the array on the right side of the root is right subtree.

        // look up a value's index in O(1)
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length-1);
    }

    // boundaries of the current subtree within the inorder array
    private TreeNode helper(int[] preorder, int left, int right){
        // for example just one element
        if(left > right) return null;

        int rootVal = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootVal);

        // find the index of the root value in the inorder array
        int rootIndex = map.get(rootVal);
        // left subtree of inorder array
        root.left = helper(preorder, left, rootIndex-1);
        root.right = helper(preorder, rootIndex + 1, right);

        return root;
    }



}