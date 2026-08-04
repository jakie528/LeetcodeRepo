class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        // initialize the result with first interval
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] currentInterval = merged.get(merged.size() -1);
            int[] newInterval = intervals[i];
            // if the newInterval start before the currentInterval end
            if(newInterval[0] <= currentInterval[1]) {
                // merged to currentInterval
                currentInterval[1] = Math.max(currentInterval[1], newInterval[1]);
            } else {
                // Non-overlapping
                merged.add(newInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}