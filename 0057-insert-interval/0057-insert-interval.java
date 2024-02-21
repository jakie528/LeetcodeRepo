class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ls = new LinkedList<>();

        int i = 0;
        // non-overlapping with newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ls.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // add the merged interval
        ls.add(newInterval);
        while (i < intervals.length) {
            ls.add(intervals[i++]);
        }

        // indicates how many sub-arrays the array will contain
        return ls.toArray(new int[ls.size()][]);
    }
}
