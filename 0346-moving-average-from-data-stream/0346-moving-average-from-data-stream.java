class MovingAverage {
    private Queue<Integer> queue;
    private int sum;
    private int size;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }
    // [3, [10],[3],[5]]
    public double next(int val) {
        // calculate the average within the size
        if(queue.size() == size) {
            sum  -= queue.poll();  // remove the head from the queue
        }
        queue.offer(val);
        sum += val;
        return (double)sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */