class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build Graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] flight : flights) {
            if(!graph.containsKey(flight[0])) {
                graph.put(flight[0], new ArrayList<>());
            }
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // min-heap (cheapest price)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        // cost, city, stopsUsed
        pq.offer(new int[]{0, src, 0});
        // cheapest cost seen for flight counts:  String: city and number of flights used
        Map<String, Integer> best = new HashMap<>();


        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], city = curr[1], stops = curr[2];

            if(city == dst) return cost;

            if(stops > k) continue;
            String key = city + "," + stops;
            // already found the same city, stops state for the same or lower cost.
            if(best.containsKey(key) && best.get(key) <= cost) continue;
            best.put(key, cost);

            for(int[] next : graph.getOrDefault(city, new ArrayList<>())){
                int newCost = cost + next[1];
                pq.offer(new int[]{newCost, next[0], stops+1});
            }
        }

        return -1;
    }
}