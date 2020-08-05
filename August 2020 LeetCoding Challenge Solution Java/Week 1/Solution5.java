/*
Add and Search Word - Data structure design

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.
   Hide Hint #1  
You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
*/
class WordDictionary {

    /** Initialize your data structure here. */
    WordDictionary[] a;
    boolean isEnd;
    public WordDictionary() {
        a = new WordDictionary[26];
        for(int i = 0; i < 26; ++i) a[i] = null;
        isEnd = false;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String w) {
        WordDictionary t = this;
        for(int i = 0; i < w.length(); ++i) {
            if(t.a[w.charAt(i)-'a'] == null) t.a[w.charAt(i)-'a'] = new WordDictionary();
            t = t.a[w.charAt(i)-'a'];
        }
        t.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String w) {
        return findW(w, this);
    }
    
    public boolean findW(String w, WordDictionary wd) {
        
        // Base condition
        if(wd == null) return false;
        if(w == null || w.length() == 0) return wd.isEnd;
        
        char ch = w.charAt(0);
        if(ch == '.') {
            for(WordDictionary x : wd.a) {
                if(x == null) continue;
                if(findW(w.substring(1), x)) return true;
            }
            return false;
        }
        if(wd.a[ch-'a'] == null) return false;
        return findW(w.substring(1), wd.a[ch-'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
