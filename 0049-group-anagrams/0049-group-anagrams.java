class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // transfer the anagram to char array
        // use map: key is the array, check whether contains the key, if it's put to the arraylist.

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = String.valueOf(charArray);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}