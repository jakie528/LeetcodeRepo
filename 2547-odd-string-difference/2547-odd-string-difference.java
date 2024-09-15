class Solution {
    public String oddString(String[] words) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            int[] diffs = new int[s.length() - 1];
            // for adc
            for(int j = 1; j < s.length(); j++) {
                diffs[j-1] = s.charAt(j) - s.charAt(j-1); // ASCII difference
            }
         System.out.print("--convert array to string---");
         String ls = Arrays.toString(diffs);
         map.putIfAbsent(ls, new ArrayList<>());  // key is "[3,-1]"
         map.get(ls).add(i); // add index as value (a list of indexes) for this example: 0,1  
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() == 1) {  // the unique one
            int uniqueIndex = entry.getValue().get(0);
            return words[uniqueIndex];
            }
        }
        return null;
    }
}