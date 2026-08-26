class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        // put two pointers in the same direction

        for(String query : queries) { 
        // iterate one word at a time
        int p1 = 0;
        int p2 = 0;
        boolean isMatch = true;
        while(p1 < query.length()) { // Test  
            if(p2 < pattern.length() && query.charAt(p1) == pattern.charAt(p2)) {
                p1++;
                p2++;
            } else if (Character.isLowerCase(query.charAt(p1)))
            {
                p1++;
            } 
            // p1 is upper case and they don't match
            else {
                isMatch = false;
                break;
            }
          }

          if(isMatch && p2 == pattern.length()) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}