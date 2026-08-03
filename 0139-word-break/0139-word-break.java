class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // whether the substring from 0 to i can be broken down into words
        boolean[] dp = new boolean[n + 1];
        // add as a valid start point
        dp[0] = true;
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        // check whether the j to i existed in the 
        // abcd [a, abc, d]
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true; 
                    break;
                }
            }
        }

        return dp[n];

    }
}