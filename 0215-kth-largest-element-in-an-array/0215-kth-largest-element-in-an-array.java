class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int val : nums) {
            pq.add(val);
            if(pq.size() > k) {
                //maintain the heap's size as k, poll the smaller elements
                pq.poll();
            }
        }
        return pq.peek();
    }
}