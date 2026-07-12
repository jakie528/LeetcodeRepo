class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Sort the array by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Create a min-heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // Add the end time to the PriorityQueue
        queue.add(intervals[0][1]);

        int rooms = 1;

        for (int i = 1; i < intervals.length; i++) {
            int earliestEndTime = queue.peek(); //4

            //Free meeting room: if the new meeting startTime is beginning after the earliestEndTime, poll the topmost element and add the new meeting.
            if (intervals[i][0] >= earliestEndTime) {
                queue.poll();
                queue.add(intervals[i][1]);
            } else {
            // add a new meeting room
                rooms++;
                queue.add(intervals[i][1]);
            }

        }

        return rooms;

    }
}