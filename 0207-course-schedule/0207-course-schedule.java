class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // a map 
        for(int[] prerequisite: prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i); //6
            }
        }

        int nodesVisited = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for(int neighbor : adj.get(node)) {
                // delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;




    }
}