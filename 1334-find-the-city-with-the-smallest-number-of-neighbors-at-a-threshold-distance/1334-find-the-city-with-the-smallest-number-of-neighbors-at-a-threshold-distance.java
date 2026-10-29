class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Floyd-warshall
        // dp: for each middle city, keep the shorter of the old entry and the route through it

        int INF = (int) 1e9;
        int[][] distance = new int[n][n];
        // distance table: itself: zero, to other city: infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        // fill in direct edges: bidirectional
        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = Math.min(distance[edge[0]][edge[1]], edge[2]);
            distance[edge[1]][edge[0]] = Math.min(distance[edge[1]][edge[0]], edge[2]);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // for each intermediate vertex, check if routing through it improves any path
                    if(distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        
        int fewestCount = n;
        int result = 0;
        // Find cities with fewest reachable within threshold
        // i represent each city
        for(int i = 0; i < n; i++) {

            int reachableCount = 0;
            for(int j = 0; j<n; j++) {
                if(i == j) {
                    continue;
                } // skip self
                if(distance[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Update the city with the fewest reachable cities
            if(reachableCount <= fewestCount) {
                fewestCount = reachableCount;
                // city with gretest number
                result = i;
            }
        }

        return result;
    }
}