class MovingAverage {
    Deque<Integer> queue = new ArrayDeque<>();
    int size = 0;
    int windowSize = 0;
    int sum = 0;
    double res = 0;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if(windowSize < size) {
            windowSize++;
            // sum += val;
            // queue.addLast(val);
            // res = sum/windowSize;
        } else {
            sum -= queue.pollFirst();
            // queue.addLast(val);
            // sum += val;
            // res = sum/windowSize;
        }
        sum += val;
        queue.addLast(val);
        res = (double)sum / windowSize;
        return res;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */