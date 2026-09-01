class StockPrice {
    // for current price
    Map<Integer, Integer> map;
    // sorted the key(price) : frequency
    TreeMap<Integer, Integer> tm;
    int currentTime;

    public StockPrice() {
        map = new HashMap<>();
        tm = new TreeMap<>();
        currentTime = 0;
    }
    
    public void update(int timestamp, int price) {
        if(timestamp > currentTime) {
            currentTime = timestamp;
        }
        // update existed timestamp
        if(map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            // decrease the old price in tm
            tm.put(oldPrice, tm.getOrDefault(oldPrice, 0)-1);
            // the price is being remove
            if(tm.get(oldPrice) == 0) {
                tm.remove(oldPrice);
            }
        } 
        // new timestamp
            map.put(timestamp, price);
            // same price may occur in different timestamp
            tm.put(price, tm.getOrDefault(price, 0) +1);
        
    }
    
    public int current() {
        return map.get(currentTime);
    }
    
    public int maximum() {
        return tm.lastKey();
    }
    
    public int minimum() {
        return tm.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */