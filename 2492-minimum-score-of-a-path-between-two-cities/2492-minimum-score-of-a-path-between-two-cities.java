class Solution {
    public int minScore(int n, int[][] roads) {
        // build the adjacency list
        // key: current node,  value: neighbor, weight
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int weight = road[2];
            // Add edge u->v
            if(!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(new int[]{v, weight});
            // Add edge v->u
            if(!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }
            graph.get(v).add(new int[]{u, weight});
        }
        // initialize variables for BFS
        //find the smallest road anywhere in the group
        int minScore = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1]; // ignore the visited[0]
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            // skip if the node has no neighbors
            if(!graph.containsKey(curr)) continue;

            for(int[] neighborInfo : graph.get(curr)) {
                int neighborCity = neighborInfo[0];
                int distance = neighborInfo[1];
                // update the current score with the current distance
                minScore = Math.min(minScore, distance);

                if(!visited[neighborCity]){
                    visited[neighborCity] = true;
                    queue.offer(neighborCity);
                }
            }
        }
        return minScore;
    }
}