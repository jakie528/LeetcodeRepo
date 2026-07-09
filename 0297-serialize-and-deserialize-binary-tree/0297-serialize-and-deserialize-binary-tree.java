/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        //Traverse the tree to get the value of each string
        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null,");
                continue; // skipping adding childern, since null has no children
            }
            // if curr is not null, append its value and its children
            sb.append(curr.val + ",");

            queue.add(curr.left);

            queue.add(curr.right);
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //check empty string
        if (data != null && data.isEmpty()) {
            return null;
        }
        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) { // assign the next two strings as nodes
                if (!values[index].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(values[index]));
                    queue.add(curr.left);
                }
                index++; // always increment the index even it's null

                if (!values[index].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(values[index]));
                    queue.add(curr.right);
                }
                index++;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));