/*
Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]

 

Constraints:

    1 <= n <= 20
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int v = 1;
        int[][] m = new int[][]{{0, 1},
                                {1, 0},
                                {0, -1},
                                {-1, 0}};
        int p = 0;
        int[][] ans = new int[n][n];
        int i = 0, j = 0;
        while(v <= n*n) {
            ans[i][j] = v++;
            int r = i+m[p][0];
            int c = j+m[p][1];
            
            if(r < 0 || r >= n || c < 0 || c >= n || ans[r][c] != 0) {
                p = (p+1)%4;
            }
            
            i = i+m[p][0];
            j = j+m[p][1];
        }
        return ans;
    }
}
