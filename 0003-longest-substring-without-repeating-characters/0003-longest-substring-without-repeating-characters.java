class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        // Map character and its most recent index in the String
        Map<Character, Integer> map = new HashMap<>();
  
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if we have seen this character before, and it's inside our current window
            if(map.containsKey(c) && map.get(c) >= left) { //a b c a e f d
            // get the current index !
            left = map.get(c) + 1;
            } 
            map.put(c, i);
            count = Math.max(count, i - left + 1);
        }
        return count;
       
    }
}