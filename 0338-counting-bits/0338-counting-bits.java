class Solution {
    public int[] countBits(int n) {
        // last bit of even is 0, last bit of odd is 1
        int[] dp = new int[n+1];

        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            // i/2 gives the counts of 1 in all bits except rightmost one
            //dp[6] = dp[3] + 0 = 2 + 0 = 2.
            dp[i] = dp[i/2] + (i%2);  
        }

        return dp;
    }
}