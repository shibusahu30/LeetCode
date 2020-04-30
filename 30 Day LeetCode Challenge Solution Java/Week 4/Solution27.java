/*
  Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/
class Solution {
    public int maximalSquare(char[][] a) {
        if (a.length == 0) return 0;
        int max = 0;
        int[][] dp = new int[a.length+1][a[0].length+1];
        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= a[i-1].length; ++j) {
                if (a[i-1][j-1] == '1') dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                if (dp[i][j] > max) max = dp[i][j]; 
            }
        }
        return max*max;
    }
}