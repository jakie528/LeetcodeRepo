class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // either add a room 
        // or replace it
        // start sorting the intervals by starting time
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < intervals.length; i++) {
            if(!pq.isEmpty() && pq.peek() <= intervals[i][0]) {
                pq.poll();
            }
            // it should contains the ending time if pq is empty
            pq.offer(intervals[i][1]);
        }

        return pq.size();
    }
}