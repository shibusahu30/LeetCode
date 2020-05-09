/*
  Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true

Example 2:

Input: 14
Output: false
*/
class Solution {
    public boolean isPerfectSquare(int n) {
        long l = 1, r = n;
        if (n == 1) return true;
        // binary search to find thre number
        while (l <= r) {
            long m = l + (r-l)/2;
            if (m*m == n) return true;
            if (m*m > n) r = m-1;
            else l = m+1;
        }
        return false;
    }
}
