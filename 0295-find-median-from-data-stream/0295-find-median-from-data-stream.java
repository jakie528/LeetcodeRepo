import java.util.NoSuchElementException;
class MedianFinder {
    Integer low;
    Integer high;
    TreeSet<Integer> data;

    public MedianFinder() {
        data = new TreeSet<>();
        low= null;
        high = null;       
    }
    
    public void addNum(int num) {
        int n = data.size();
        data.add(num);  // insert into the treeset

        if(n == 0) {
            low = num;
            high = num;
        } else if( n%2 == 1) {
            //odd size before, even size now, high must not equal to low
            if(num < low) 
            // return the greatest element in this set which is strictly less than the given element
            low = data.lower(num); // 1 3 4 6, data.lower(3), return 1
            else 
            high = data.higher(high);
        } else if ( n % 2 == 0) {
            //even before, odd now, low = high
            if(num > low && num < high) {
                low = data.higher(low);  // 1 3(l) 5 6(h) 7
                high = data.lower(high);
            } else if( num <= low) {  // 0 1 3(l) 6(h) 7
                high = data.lower(high);
            } else // num >= high  1 3(l) 6(h) 7 8
            {
                low = data.higher(low);
            }
        }
    }
    
    public double findMedian() {
           if (high == null) {
            return low;
           }
            return (Math.round(low) + Math.round(high)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
* Complexity
Time complexity of addNum: O(log n)
Time complexity of findMedian: O(1)
The space complexity is O(n) to store the elements in the TreeSet.
*/