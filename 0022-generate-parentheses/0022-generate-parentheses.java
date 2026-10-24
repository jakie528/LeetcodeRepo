class Solution {
    private List<String> res;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.n = n;
        dfs("", 0, 0);
        return res;
    }

    private void dfs(String s, int open, int close) {
        // base case
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        if (open < n) {
            // add open parenthesis and increment the open count
            dfs(s + "(", open + 1, close);
        }

        if (close < open) {
            // add a closing parenthesis and increment the close count
            dfs(s + ")", open, close + 1);
        }
    }
}