/*
Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

 

Note:

    All inputs are consist of lowercase letters a-z.
    The values of words are distinct.
*/
class Solution {
    // Trie Node
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    // build the trie from words array
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode current = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a'; // index adjustment
                if (current.children[i] == null) 
					current.children[i] = new TrieNode();
                current = current.children[i];
            }
            current.word = w; // assign word w to word of trie node
        }
		
        return root;
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        // build the trie from using dictionary words.
        TrieNode root = buildTrie(words);

        // call the dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        char c = board[i][j]; // get the current character from the board at i, j
        if (c == '*' || root.children[c - 'a'] == null)
            return;
        root = root.children[c - 'a'];
        if (root.word != null) {   // found one words add in the result list
            result.add(root.word);
            root.word = null;     // de-duplicate remove the word from trie
        }

        board[i][j] = '*'; // update the character of at i , j no need for visited array
        if (i > 0) dfs(board, i - 1, j, root, result); // up
        if (j > 0) dfs(board, i, j - 1, root, result); // left
        if (i < board.length - 1) dfs(board, i + 1, j, root, result); // down
        if (j < board[0].length - 1) dfs(board, i, j + 1, root, result); // right
        board[i][j] = c; // backtrack the character
    }
}
