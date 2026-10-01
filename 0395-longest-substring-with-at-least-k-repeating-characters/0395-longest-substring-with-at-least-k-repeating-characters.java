class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        //包含 c 种字符的最长合法子串
        for(int c= 1; c <= 26; c++) {
            int[] freq = new int[26];
            int left = 0;
            int right = 0;

            int unique = 0; // 当前窗口内不同字符的种类数
            int countAtLeastK = 0; // 当前窗口内频率 >= k 的字符种类数

            while(right < n) {
                //1. right pointer expand
                int rightChar = s.charAt(right) - 'a';
                if(freq[rightChar] == 0) {
                    unique++; // find a new character
                }
                freq[rightChar]++;
                if(freq[rightChar] == k){
                    countAtLeastK++;
                }
                right++;

                //2. left pointer shrink
                while(unique >c) {
                int leftChar = s.charAt(left)-'a';
                if(freq[leftChar] == k) {
                    countAtLeastK--; // 这种字符的频率跌破了 k，达标种类数 -1
                }
                freq[leftChar]--;
                if(freq[leftChar] == 0) {
                    unique--;
                }
                left++;
                }

                //3. 检查合法性并更新最大长度
                // 如果当前窗口内刚好有 c 种字符，且这 c 种字符出现的频率全都 >= k
                if(unique == c && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }
}