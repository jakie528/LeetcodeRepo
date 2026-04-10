class Solution {
    // pq has a natural order
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> ticket : tickets) {
             // if departure airport exists, the new PQ will not insert
                map.putIfAbsent(ticket.get(0),new PriorityQueue<>());
                map.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK");

        return res;
    }

    private void dfs(String start){
        PriorityQueue<String> pq = map.get(start); // JFK to ATL/SFO
        while(pq != null && !pq.isEmpty()) {
            dfs(pq.poll()); // the poll destination becomes the next airport
        }
        //DFS reaches dead ends first, but dead ends go at the END of the itinerary.
        res.addFirst(start);
    }


}