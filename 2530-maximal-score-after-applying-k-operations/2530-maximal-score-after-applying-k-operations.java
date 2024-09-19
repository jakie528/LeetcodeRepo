
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        long score = 0;
     
        for(int i = 0; i < k; i++) {
            //use to add to the score
            int num = pq.poll();
            score += num;

            //place replace Element into the original array
            int value = (int)Math.ceil(num/3.0);

            // add the new element into the pq
            pq.add(value);
        }

        return score;
    }
}