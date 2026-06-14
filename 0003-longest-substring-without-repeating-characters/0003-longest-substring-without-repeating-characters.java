class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        // map store the character : index pair
        HashMap<Character, Integer> map = new HashMap<>();


        //if map.value >1,compare the length
        for(int i = 0, j=0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                //to ignore stale entries that point behind the current window:
                i = Math.max(map.get(s.charAt(j)),i);
            }

            // no contains the same character

            maxLength = Math.max(maxLength, j-i+1);
            //slot: where i should jump to if this character shows up again
            map.put(s.charAt(j), j+1);
        }
        return maxLength;
        
    }
}