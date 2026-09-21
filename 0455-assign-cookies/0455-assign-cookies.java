class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);  // children
        Arrays.sort(s);  // cookies
        // two pointer
        int i = 0;  // represent the current child
        int j = 0;  // represent the current cookies
        int count = 0;
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}