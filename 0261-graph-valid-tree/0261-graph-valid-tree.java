class Solution {
    public boolean validTree(int n, int[][] edges) {
        // tree must contain n-1 edges
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]); 
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            // process the node's neighbor
            int node = queue.poll();  // 0 
            for (int neighbor : adjacencyList.get(node)) { // 1 
                if (seen.contains(neighbor)) 
                    continue; 
                    // add the 1 as visited
                seen.add(neighbor);
                // queue add the neighbor as BFS
                queue.offer(neighbor);  // 1 
            }
        }

        // we have verified at the beginneing 
        return seen.size() == n; 
    }
}