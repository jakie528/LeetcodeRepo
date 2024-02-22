class TimeMap {
    private HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;

    public TimeMap() {
        keyTimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList());
        }

        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!keyTimeMap.containsKey(key)) {
            return "";
        }
        //get(0) gets the first key-value pair in this list.
        if(timestamp < keyTimeMap.get(key).get(0).getKey()) {
            return "";
        }

        //using binary search
        int left = 0;
        int right = keyTimeMap.get(key).size();

        while(left < right) {
            int mid = (left + right) / 2;
            if(keyTimeMap.get(key).get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // If iterator points to first element it means, no time <= timestamp exists.
        if(right == 0) {
            return "";
        }
        return keyTimeMap.get(key).get(right-1).getValue();
    }
}
//solution1:key as key, value:(hashmap(timestamp, value))

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */