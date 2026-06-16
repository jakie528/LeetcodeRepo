class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;

        if(n == 0) return 0;


        boolean[][] dp = new boolean[n][n];

        // Base case
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        for(int i = 0; i < n-1; i++) {
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            ans += (dp[i][i+1] ? 1 : 0);
        }

        // all other cases: substrings of length 3 to n
        for(int len = 3; len <= n; len++){
            for(int startIndex = 0; startIndex <= n - len; startIndex++){
            int endIndex = startIndex + len -1;

            // 状态转移：内部是回文 且 头尾字符相等
            dp[startIndex][endIndex] = dp[startIndex + 1][endIndex - 1] && (s.charAt(startIndex) == s.charAt(endIndex));

            if(dp[startIndex][endIndex]) {
            ans++;
            }

            }
        }

        return ans;
    }
}