class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // find sorted order of words
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            // a shorter prefix must always come before the longer word. "abc" should always appear before "abcd". abcd abc (false)
            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {

            if(word1.charAt(j) != word2.charAt(j)) {
                // add c2 to the list of c1
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                adjList.get(c1).add(c2);
                counts.put(c2, counts.get(c2)+1);   // indegree + 1
                break; // Every pair of adjacent words gives us at most one piece.
                //If the other pairs of words never give us any rules about a specific character, then that character's order is unconstrained. it can be placed anywhere in the output string
            }
        }
        }

        // BFS
        StringBuilder sb  = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c : counts.keySet()) {
            if(counts.get(c).equals(0)) { // find the first character
            queue.add(c);
            }
        }

        while(!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for(Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if(counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }

        if(sb.length() == counts.size()) {
            return sb.toString();
        }

        return "";

        

        









        
    }
}