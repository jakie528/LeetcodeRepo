class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    // ArrayList<Double> res = new ArrayList<>();

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();

    }

    public void addNum(int num) {
        // insert new element to the maxheap
        maxHeap.add(num);

        // Move the top of the max heap to min heap to maintain the order
        int temp;

            temp = maxHeap.poll();  
            minHeap.add(temp);

        // 
        if (maxHeap.size() < minHeap.size()) {
            temp = minHeap.poll();
            maxHeap.add(temp);
        }
    }

    public double findMedian() {
        double median;
        if (minHeap.size() != maxHeap.size()) {
            // odd number 
            median = maxHeap.peek();
        } else {
            // even number
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        // res.add(median);

        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */