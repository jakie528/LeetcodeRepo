class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        for (char c : arr1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : arr2) {
            map.put(c, map.getOrDefault(c, 0) - 1);

        }

        // for(Map.Entry<Character, Integer> entry : map.entrySet()){
        //     if(entry.getValue() != 0) {
        //         return false;
        //     }
        // }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}