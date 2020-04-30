/*
Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

*/
class Solution {
    public int numIslands(char[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    ++c;
                    foo(grid, i, j);
                }
            }
        }
        return c;
    }
    void foo(char[][] arr, int i, int j) {
        if (i < 0 || i == arr.length || j < 0 || j == arr[i].length || arr[i][j] == '0') return;
        
        arr[i][j] = '0';
        foo(arr, i+1, j);
        foo(arr, i, j+1);
        foo(arr, i, j-1);
        foo(arr, i-1, j);
    }
}