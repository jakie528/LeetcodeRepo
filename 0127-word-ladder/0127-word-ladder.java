class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) return level;
                // to find the current word's all neighbor word
                List<String> neighbors = neighbors(currentWord);
                for(String neighbor : neighbors) {
                    if(words.contains(neighbor)) {
                        words.remove(neighbor); // mark as not visit again
                        queue.add(neighbor); // find a valid transformation
                    }
                }
            }
        }
        return 0;  
    }

    public List<String> neighbors(String string) {
        char[] chars = string.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c == temp) continue; // skip same letter
                chars[i] = c;
                result.add(new String(chars));
            }
            chars[i] = temp; // restore before mob=ving to next character position
        }
        return result; // return all the neighbors
    }
}