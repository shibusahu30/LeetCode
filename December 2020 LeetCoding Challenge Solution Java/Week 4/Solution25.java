/*
Diagonal Traverse

Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:

 

Note:

The total number of elements of the given matrix will not exceed 10,000.
*/
class Solution {
    public int[] findDiagonalOrder(int[][] m) {
        if (m == null || m.length == 0) {
            return new int[0];
        }
        int N = m.length, M = m[0].length;
        int ans[] = new int[N*M];
        int r = 0;
        int d = 1;
        int i = 0, j = 0;
        while(i < N && j < M) {
            ans[r++] = m[i][j];
            
            int ni = i + d*(-1);
            int nj = j + d;
            
            if(ni >= 0 && ni < N && nj >= 0 && nj < M) {
                i = ni;
                j = nj;
            } else {
                // System.out.println("1."+i+" "+j+" "+d);
                if(d == 1) {
                    i += (j == M-1) ? 1 : 0;
                    j += (j == M-1) ? 0 : 1;
                } else {
                    j += (i == N-1) ? 1 : 0;
                    i += (i == N-1) ? 0 : 1;
                }
                d *= -1;
                // System.out.println("2."+i+" "+j+" "+d);
            }
        }
        return ans;
    }
}
