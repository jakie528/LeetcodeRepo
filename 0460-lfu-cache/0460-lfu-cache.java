class LFUCache {
    // one map for(key, value)
    private Map<Integer, Integer> vMap = new HashMap<>();
    // another map for tie: (key, frequencies)
    private Map<Integer, Integer> freMap = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqBuckets;  // the same frequencies with the insertion order
    //minFreq is used in eviction — to instantly know which bucket to evict from without scanning all frequencies.
    private int minFreq;
    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        vMap = new HashMap<>();
        freMap = new HashMap<>();
        freqBuckets = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        if(!vMap.containsKey(key)) 
        return -1;
        updateFreq(key);
        return vMap.get(key);
    }
    
    public void put(int key, int value) {
        // Update the value of the key if present
        if (vMap.containsKey(key)) {
        vMap.put(key,value);
        updateFreq(key);
         } else {
            if(vMap.size() == capacity) {
                evict();
            }
            vMap.put(key, value);
            // // Insert new key with frequency 1
            freMap.put(key,1);
            if(!freqBuckets.containsKey(1)) {
                freqBuckets.put(1, new LinkedHashSet<>());
            }
            freqBuckets.get(1).add(key);
            minFreq = 1; // new key always has freq 1
         }




        // wit the same frequencies, least recently used key would be invalidated.
        // ->HashMap does not store the insertion order
        // need a sorted map (key:frequency, value: a list of elements with the same frequency)


        
    }
    private void updateFreq(int key) {
        int freq = freMap.get(key);
        freMap.put(key, freq+1);

        // remove the key from its old bucket
        freqBuckets.get(freq).remove(key);

        // remove the current minimum bucket
        if(freqBuckets.get(freq).isEmpty()) {
            freqBuckets.remove(freq); // remove the bucket
            if(minFreq == freq) 
            minFreq++;  
        }
        // add to the next freqBucket
        if(!freqBuckets.containsKey(freq+1)){
            freqBuckets.put(freq + 1, new LinkedHashSet<>());
        }
        freqBuckets.get(freq+1).add(key);
    }

    private void evict(){
        LinkedHashSet<Integer> minBucket = freqBuckets.get(minFreq);
        int lruKey = minBucket.iterator().next();
        minBucket.remove(lruKey);
        if(minBucket.isEmpty()) {
            freqBuckets.remove(minFreq);
        }
        vMap.remove(lruKey);
        freMap.remove(lruKey);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */