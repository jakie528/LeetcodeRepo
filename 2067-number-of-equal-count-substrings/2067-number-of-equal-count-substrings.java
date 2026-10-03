class Solution {
    public int equalCountSubstrings(String s, int count) {
        // sliding window if it exceed the length, pass it
        int n = s.length();
        int res = 0;

        // looking for characters from 1 to 27
        for(int i = 1; i < 27; i++) {
            int windowSize = i * count;
            // window size exceed the count, terminate
            if(windowSize > n) {
                break;
            }
            int[] charFrequency = new int[26];
            int charsWithTargetCount = 0;

            // sliding window
            for(int j = 0; j < n; j++) {
                int rightCharIndex = s.charAt(j) - 'a';
                charFrequency[rightCharIndex]++;  //rightCharIndex not change
                if(charFrequency[rightCharIndex] == count) {
                    charsWithTargetCount++;
                }
                else if(charFrequency[rightCharIndex] == count +1){
                    charsWithTargetCount--;
                }
                // remove the left side
                if(j >= windowSize) {
                    int leftCharIndex = s.charAt(j - windowSize)-'a';
                    charFrequency[leftCharIndex]--;
                    if(charFrequency[leftCharIndex] == count){
                        charsWithTargetCount++;
                    } else if(charFrequency[leftCharIndex] == count -1) {
                        charsWithTargetCount--;
                    }
                }
                //i unique characters in the window appear exactly count times, so we found a valid equal count substring.
                if(charsWithTargetCount == i) {
                    res++;
                }
            }
        }
        return res;
    }
}