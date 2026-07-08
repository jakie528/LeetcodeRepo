/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        // connect the original node to its cloned node
        HashMap<Node, Node>  map = new HashMap<>();

        Node startNode = new Node(node.val);

        map.put(node, startNode);
        queue.add(node);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            for(Node neighbor : curr.neighbors) {
                if(!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                    Node clonedNeighbor = new Node(neighbor.val);
                    map.put(neighbor, clonedNeighbor);
                }
                // draw the edges between the cloned curr node and the cloned neighbor
                // add: neighbor is a list
                // map.get(neighbor): Gets the cloned version of the neighbor node
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return startNode;
    }
}