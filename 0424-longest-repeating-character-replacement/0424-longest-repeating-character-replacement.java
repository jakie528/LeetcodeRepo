class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int mostChar = 0;

        int res = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0)+1);

            mostChar = Math.max(mostChar, map.get(c));

            if(i - start + 1 - mostChar > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start += 1;
            }

            res = Math.max(res, i-start+1);

        }
        return res;

    }
}