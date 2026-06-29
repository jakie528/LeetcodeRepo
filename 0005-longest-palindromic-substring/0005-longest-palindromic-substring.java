class Solution {
    public String longestPalindrome(String s) {

        int[] ans = { 0, 0 };


        for (int i = 0; i < s.length(); i++) {
            // odd
            int oddLen = expandAroundCenter(s, i, i);
            // even number
            int evenLen = expandAroundCenter(s, i, i + 1);
            int Len = Math.max(oddLen, evenLen);

            if(Len > ans[1] - ans[0] + 1) {
            ans[0] = i - (Len - 1) / 2;
            ans[1] = i + Len / 2;
            }
        }

        return s.substring(ans[0], ans[1] + 1);
    }

    private int expandAroundCenter(String s, int startIndex, int endIndex) {
        int n = s.toCharArray().length;

        // the condition for continuing expanding
        while (startIndex >= 0 && endIndex < n && s.charAt(startIndex) == s.charAt(endIndex)) {
            startIndex--;
            endIndex++;
        }

        return endIndex - startIndex - 1;

    }
}