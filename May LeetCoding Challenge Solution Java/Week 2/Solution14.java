/*
 Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.
*/
class Trie {

    /** Initialize your data structure here. */
    Trie[] t;
    boolean isEnd;
    public Trie() {
        t = new Trie[26];
        for (int i = 0; i < 26; ++i) t[i] = null;
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if (temp.t[ch] == null) temp.t[ch] = new Trie();
            temp = temp.t[ch];
        }
        temp.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if (temp.t[ch] == null) return false;
            temp = temp.t[ch];
        }
        return ((temp != null) && temp.isEnd); 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); ++i) {
            int ch = word.charAt(i) - 'a';
            if (temp.t[ch] == null) return false;
            temp = temp.t[ch];
        }
        return (temp != null); 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
