/*
Longest Mountain in Array

You may recall that an array arr is a mountain array if and only if:

    arr.length >= 3
    There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

 

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.

 

Constraints:

    1 <= arr.length <= 104
    0 <= arr[i] <= 104

 

Follow up:

    Can you solve it using only one pass?
    Can you solve it in O(1) space?
*/
class Solution {
    public int longestMountain(int[] A) {
        int ans = 0;
        if(A.length <= 2) return ans;
        int ics = 0;
        int dcs = 0;
        int pre = A[0];
        int fg = -1; // 0 -- dc 1 -- ic -1 -- flat
        for(int i = 1; i < A.length; ++i) {
            if(A[i] > pre) {
                if(fg == 1) ++ics;
                else ics = 2;
                dcs = 0;
                fg = 1;
            }
            else if(A[i] < pre) {
                if(fg == 0) ++dcs;
                else dcs = 2;
                fg = 0;
            } else {
                fg = -1;
                ics = 0;
                dcs = 0;
            }
            if(ics > 0 && dcs > 0) ans = Math.max(ans, ics+dcs-1);
            pre = A[i];
        }
        return ans;
    }
}
