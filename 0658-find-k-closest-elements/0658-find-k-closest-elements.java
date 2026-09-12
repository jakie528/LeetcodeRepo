class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // Max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[0] == b[0]) {
                // descending of arr[i], the larger value to be evicted
            return Integer.compare(b[1], a[1]);
        }
            return Integer.compare(b[0], a[0]);
            });
        // calculate the distance
        for(int i = 0; i < arr.length; i++) {
            int distance = Math.abs(arr[i]-x);

            pq.offer(new int[]{distance, arr[i]});
            if(pq.size() > k) {
                pq.poll();
            }
        }

        for(int[] pair : pq) {
            res.add(pair[1]);
        }

        Collections.sort(res);

        return res;
    }
}