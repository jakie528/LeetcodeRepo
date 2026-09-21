class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // sliding window
        int left = 0; 
        // 
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        // s = "eceba"
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);  // b
            map.put(c, map.getOrDefault(c,0)+1); // ece
            // at most k elements
            while(map.size() > k) {  
            map.put(s.charAt(left), map.get(s.charAt(left))-1);
            
            if(map.get(s.charAt(left)) == 0) {
                map.remove(s.charAt(left));
            }
            left++;
        }
            maxLength = Math.max(maxLength, i-left+1);  // 3
        }

        return maxLength;
    }
}