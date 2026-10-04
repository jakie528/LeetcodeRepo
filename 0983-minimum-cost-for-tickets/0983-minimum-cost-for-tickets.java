class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));  // the days[0]
        for(int i = 1; i < n; i++) {
            // costs1
            dp[i] = dp[i-1]+costs[0];
            //use 7 day passes
            int j = i;
            while(j >= 0 && days[i] - days[j] < 7) {
                j--;
            }
            int costs7;
            if(j >= 0) {
                costs7 = dp[j] + costs[1]; // add to the cost of previous uncovered days
            } else {
                costs7 = costs[1];
            }
            //use 30 day passes
            int z = i;
            while(z >= 0 && days[i] - days[z] < 30) {
                z--;
            }
            int costs30;
            if(z >= 0) {
                costs30 = dp[z] + costs[2]; // add to the cost of previous uncovered days
            } else {
                costs30 = costs[2];
            }

            dp[i] = Math.min(dp[i-1]+costs[0], Math.min(costs7, costs30));
        }
        return dp[n-1];
    }
}