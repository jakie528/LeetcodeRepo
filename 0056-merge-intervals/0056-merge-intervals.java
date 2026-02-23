class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // use to store the final intervals
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] interval: intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } 
            // there is overlap, merge the current and previous interval
            else {
                // modify through the reference
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}