class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // int[][] res = new int[][];
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // no-overlapping 
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2. for the current intervals, we have skipped all intervals that 
        // are strictly before newInterval
        // overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // no overlapping
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}