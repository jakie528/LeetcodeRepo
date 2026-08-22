class Solution {
    public int minDistance(String word1, String word2) {
        // 2 way dp
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        // process 1st column and 1st row.
        if(m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }
        // If one string is empty, then answer
        // is length of the other string
        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else 
                // insert, a aq dp[i][j-1] + 1
                // delete a aq dp[i-1][j] +1
                // replace a aq => "" a +1: dp[i-1][j-1]
                {
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1],Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }
}