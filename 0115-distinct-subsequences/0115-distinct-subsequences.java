class Solution {
    public int numDistinct(String s, String t) {
        int res = 0;
        int m = s.length();
        int n = t.length();
        // the number of ways to form the first j charcters of String t using the first i characters of string s
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;  //one way to form an empty string (by select nothing)
        }
        // an empty string cannot form a non-empty string t
        // for(int j = 0; j <= n; j++) {
        //     dp[0][j] = 0;
        // }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //s[i-1] != t[j-1]
                if(s.charAt(i-1) != t.charAt(j-1)) {
                   dp[i][j] = dp[i-1][j]; // skip the i character in s
                } else { // s[i-1] == t[j-1] (use or not use)
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}