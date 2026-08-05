class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //add values to the heap
        maxHeap.addAll(freqMap.values());

        int intervals = 0;

        while (!maxHeap.isEmpty()) {
            int slots = n + 1;
            // a temporary list to store the current count
            List<Integer> store = new ArrayList<>();

            while (slots > 0 && !maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll() - 1; //2
                intervals++;
                slots--;
                if (currentFreq > 0) {
                    store.add(currentFreq);
                }
            }

            for (int count : store) {
                maxHeap.offer(count); //2
            }

            if (!maxHeap.isEmpty()) {
                intervals += slots;
            }
        }
        return intervals;
    }
}