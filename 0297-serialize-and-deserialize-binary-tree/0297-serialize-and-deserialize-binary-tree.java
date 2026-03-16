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

    // recursive serialization
    public String rserialize(TreeNode root, String str) {
        if(root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> ls) {
        if(ls.get(0).equals("null")){
            ls.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(ls.get(0)));
        ls.remove(0);
        root.left= rdeserialize(ls);
        root.right = rdeserialize(ls);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(array));
        return rdeserialize(data_list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));