class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // sort in decreseing order
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i = 0; i < n; i++) {
            // remove indices outside of the window
            // valid index is from [i-k+1, i]
            if(!deque.isEmpty() && deque.peekFirst() <= i-k) {
                // the maximum value of the window at front of the deque
                deque.pollFirst();
            }

            // to keep the current window maximum at the front of the queue
            // we need to remove the smaller
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // it always end up being max
            deque.offerLast(i);

            // after i = k-1, it start to record every time the current front of the queue.
            if(i >= k -1){
                // the front of the queue
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }

        return res;

    }
}