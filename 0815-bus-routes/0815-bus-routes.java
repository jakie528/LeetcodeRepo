class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }

        // create a map mapping bus stop to bus route index
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int stop : routes[i]) {
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        // Step2: initialize the BFS queue and visited set
        for(int route : map.getOrDefault(source, new ArrayList<>())) { //source stop to its route index
            queue.offer(new int[]{route, 1});  
            visited.add(route);  
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int routeIndex = current[0];
            int routeCount = current[1];

            //if the target stop in the current route, directly return current count
            for(int stop : routes[routeIndex]) {
                if(stop == target) {
                    return routeCount;
                }

                // add neighbor to the queue
                for(int connectedRoute : map.getOrDefault(stop, new ArrayList<>())) {
                    if(!visited.contains(connectedRoute)) {
                        queue.offer(new int[]{connectedRoute, routeCount+1});
                        visited.add(connectedRoute);
                    }
                }
            }
        }
        return -1;
    }
}