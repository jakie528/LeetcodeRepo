class Solution {
    //We need to return the Maximum Element from each window.
    public int[] maxSlidingWindow(int[] nums, int k) {
        // use monotonic decreasing queue
            Deque<Integer> dq = new ArrayDeque<>();  // store index
            int n = nums.length;
            int[] res = new int[n-k+1];
            int ri = 0;

            for(int i = 0; i < n; i++) {

                // set the window size
                if(!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                    dq.pollFirst(); // remove the element from the front of the queue
                }

                // Remove from back all indices whose values are <= current value
                while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) { 
                    dq.pollLast(); // poll all of them that's small than current value
                }
                // add the current maximum value
                dq.addLast(i);

                if(i >= k - 1) {
                    res[ri++] = nums[dq.peekFirst()];
                }
            }

            return res;
 
    }
}