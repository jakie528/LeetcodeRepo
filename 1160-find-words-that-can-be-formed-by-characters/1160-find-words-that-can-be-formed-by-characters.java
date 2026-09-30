class Solution {
    private Map<Character, Integer> map;

    public int countCharacters(String[] words, String chars) {
        // use a map to record the frequencies of each character
        // the frequenciese of charactres must be >= word/s characters
        map = new HashMap<>();
        for(int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int sum = 0;

        for(String word : words) {
            if(formByCharacter(word)) {
                sum += word.length();
            }
        }
        return sum;   
    }

    private boolean formByCharacter(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        // [c:1 a:1 t:1] [a:2 c:1,h:1,t:1]
        // if the value of the freq > map.get(charAt());
        for(Map.Entry<Character, Integer> entry :freq.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

           int mapCount = map.getOrDefault(c, 0);
           if(count > mapCount) {
            return false;
           }
        }
        return true;
    }
}