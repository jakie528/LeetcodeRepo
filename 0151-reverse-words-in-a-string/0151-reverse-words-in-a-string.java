class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuffer result = new StringBuffer();
        for(int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }

        return result.toString().trim();

        
    }
}