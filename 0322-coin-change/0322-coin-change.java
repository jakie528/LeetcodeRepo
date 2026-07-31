class Solution {
    public int coinChange(int[] coins, int amount) {
        // store the answer for every amount from 0 up to amount
        int[] dp = new int[amount+1];
        // amount is our infinity value, e.g. if amount is 1, then amount + 1 would be impossible
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // current amount from 1 to amount
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    // dp[i-coin[i]] minimum number of coins needed to make that leftover amount 
                    //dp[i] holds the current minimum number of coins in dp[i]
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1); 
                }
            }
        }
        // no update to the answer
        if(dp[amount] == amount + 1) {
            return -1;
            
        } else {
            // the current minimum one
            return dp[amount];
        }
        }
}