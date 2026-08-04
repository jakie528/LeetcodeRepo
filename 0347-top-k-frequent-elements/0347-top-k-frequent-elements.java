class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        // max-heap by frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(map.get(n2), map.get(n1)));

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }


        // add all the key from the frequency HashMap
        for(int num : map.keySet()) {
            pq.add(num);
        }

        int i = 0;

        int[] res = new int[k];

        while(i < k) {
            int ele = pq.poll();
            res[i]=ele;
            i++;
        }

        return res;
    }
}