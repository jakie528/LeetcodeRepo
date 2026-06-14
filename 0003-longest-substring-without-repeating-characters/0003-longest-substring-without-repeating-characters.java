class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        // map store the character : index pair
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;


        //abba
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c)>=start ) {
                start = map.get(c) + 1;
            }

            // no contains the same character

            maxLength = Math.max(maxLength, i-start+1);
            //slot: where i should jump to if this character shows up again
            map.put(c,i);
        }
        return maxLength;
        
    }
}