class Solution {
    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ls = new ArrayList<>();
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ls);
            }
        }

        return ls;
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.children[c - 'a'] = newNode;
            }
            // move the curr pointer to the newly created node
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
        curr.word = word;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> list) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (board[i][j] == '#') {
            return;
        }
        int boardIndex = board[i][j] - 'a';

        // If no child exists for this character, return
        if (node.children[boardIndex] == null) {
            return;
        }
        // move to the cild node
        node = node.children[boardIndex];

        if (node.word != null) {
            list.add(node.word);
            node.word = null; // avoid duplicate additions
        }
        // mark original chart as visited
        char originalChar = board[i][j];
        board[i][j] = '#';

        int[] rowOffset = { -1, 0, 1, 0 };
        int[] colOffset = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int newRow = i + rowOffset[k];
            int newCol = j + colOffset[k];
            dfs(board, newRow, newCol, node, list);
        }
        board[i][j] = originalChar;

    }
}

class TrieNode {
    TrieNode[] children;
    Boolean isEndOfWord;
    String word;

    public TrieNode() {
        word = null;
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}