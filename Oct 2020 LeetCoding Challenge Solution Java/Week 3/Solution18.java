/*
Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int r = 0;
        int c = matrix[0].length-1;
        while(r < matrix.length && c >= 0) {
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] < target) ++r;
            else --c;
        }
        return false;
    }
}
