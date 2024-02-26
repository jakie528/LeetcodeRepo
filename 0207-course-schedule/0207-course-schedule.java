class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //numsber of edges entering node x
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        //eighbors of node x
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]); //add high level course
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        //push all the nodes with indegree zero in the queue.
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for(int neighbor : adj.get(node)) {
                //delete the edge "node -> neighbor"
                indegree[neighbor]--;  // delete the dege point to the advance course
                if(indegree[neighbor] == 0) { 
                    queue.offer(neighbor);
                }
            }

        }
        return nodesVisited == numCourses;
    }
}