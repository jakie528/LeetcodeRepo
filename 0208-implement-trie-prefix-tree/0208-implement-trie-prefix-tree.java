class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode(); 
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                // insert the new node
                curr.children[c - 'a'] = newNode;
            }
            // move the curr pointer to the newly created node
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        // initilize the curr pointer to the root node
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            // the key is not existed
            if(curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];

    }


}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */