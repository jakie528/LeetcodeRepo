class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i]; // 1
            }
            if (prices[i + 1] > minValue) {
                profit = Math.max(profit, prices[i + 1] - minValue);
            }
        }
        return profit;

    }
}