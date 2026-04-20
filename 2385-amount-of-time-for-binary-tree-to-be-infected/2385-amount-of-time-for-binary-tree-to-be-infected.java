
import java.time.chrono.MinguoChronology;/**
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
    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        convert(root, 0, map);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int minute = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize > 0) {
                int current = queue.poll();
                for(int num : map.get(current)){
                    if(!visited.contains(num)){
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize--;
            }
            // incremented AFTER every level, including the last
            minute++;
        }
        return minute - 1;
    }

    public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> map) {
        if(current == null) {
            return;
        }

        if(!map.containsKey(current.val)) {
            map.put(current.val, new HashSet<>());
        }

        Set<Integer> adjacencyList = map.get(current.val);

        if(parent != 0) {
            adjacencyList.add(parent);
        }

        if(current.left != null){
            adjacencyList.add(current.left.val);
        }

        if(current.right != null) {
            adjacencyList.add(current.right.val);
        }

        convert(current.left, current.val, map);
        convert(current.right, current.val, map);

    }
}