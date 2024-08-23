class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] maxLeft = new int[size];
        maxLeft[0] = height[0];

        int[] maxRight = new int[size];
        maxRight[size - 1] = height[size-1];

        int[] minLR = new int[size];

        int ans = 0;

        for(int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }

        for(int i = size - 2; i >= 0; i-- ) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        for(int i = 1; i < size - 1; i++ ) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        } //the first one and the last one must no water
        return ans;      
    }
}