class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.children[c - 'a'] = newNode;
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        // base case: we reach the end of the word
        if (index == word.length()) {
            return node.isWord; // Return true if it's a word, false otherwise
        }

        char c = word.charAt(index);

        // If the character is a dot '.'

        if (c == '.') {
            // Loop through all 26 children in node.children
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        // If it's a regular letter
        else {
            if (node.children[c - 'a'] == null) {
                return false;
            } else {
                // pass the child node
                return dfs(word, index + 1, node.children[c - 'a']);
            }
        }

    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */