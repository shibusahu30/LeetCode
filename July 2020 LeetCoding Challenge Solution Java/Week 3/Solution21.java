/*
Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 

Constraints:

    board and word consists only of lowercase and uppercase English letters.
    1 <= board.length <= 200
    1 <= board[i].length <= 200
    1 <= word.length <= 10^3
*/
class Solution {
    boolean[][] isVis;
    public boolean exist(char[][] b, String w) {
        
        isVis = new boolean[b.length][b[0].length];
        
        for(int i = 0; i < b.length; ++i) {
            for(int j = 0; j < b[i].length; ++j) {
                if(b[i][j] == w.charAt(0) && isPossible(i, j, b, w, 0)) return true;
            }
        }
        return false;
    }
    public boolean isPossible(int i, int j, char[][] b, String w, int l) {
        if(l == w.length()) return true;
        if(i < 0 || j < 0 || i >= b.length || j >= b[0].length || isVis[i][j] || b[i][j] != w.charAt(l)) return false;
        isVis[i][j] = true;
        if(isPossible(i+1, j, b, w, l+1) || isPossible(i-1, j, b, w, l+1) || isPossible(i, j+1, b, w, l+1) || isPossible(i, j-1, b, w, l+1)) return true;
        isVis[i][j] = false;
        return false;
    }
}
