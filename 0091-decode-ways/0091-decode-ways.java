class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        if (s.charAt(0) == '0') {
            return 0;
        } else {
            // the number of ways to decode the 1st character of the String
            dp[1] = 1;
        }

        // check if successful single digit decode is possible
        for(int i = 2; i < dp.length; i++) {
            if(s.charAt(i-1) != '0') {
            // check single digit
            dp[i] = dp[i-1]; // 1 way
            } 
            
            int twoDigit = Integer.valueOf(s.substring(i-2, i)); // 0 1
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2]; // 126
            }
        }

        return dp[s.length()];


    }
}