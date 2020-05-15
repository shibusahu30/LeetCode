/*
Maximum Sum Circular Subarray

Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

 

Example 1:

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3

Example 2:

Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

Example 3:

Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

Example 4:

Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

Example 5:

Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1

 

Note:

    -30000 <= A[i] <= 30000
    1 <= A.length <= 30000
*/
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int S = 0;  // S = sum(A)
        for (int x: A)
            S += x;

        int ans1 = kadane(A, 0, A.length-1, 1);
        int ans2 = S + kadane(A, 1, A.length-1, -1);
        int ans3 = S + kadane(A, 0, A.length-2, -1);
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    public int kadane(int[] A, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            cur = sign * A[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
