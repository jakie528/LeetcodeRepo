class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
        // min heap sorted by endtime 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        for (int[] interval : intervals) {
            // the most earlier end time finish, can start the meeting in the same meeting room
            if (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
                pq.poll();
            }
            pq.add(interval);
        }
        return pq.size();
    }
}