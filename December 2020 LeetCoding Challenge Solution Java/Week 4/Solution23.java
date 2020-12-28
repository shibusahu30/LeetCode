/*
Next Greater Element III

Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

 

Example 1:

Input: n = 12
Output: 21

Example 2:

Input: n = 21
Output: -1

 

Constraints:

    1 <= n <= 231 - 1
*/
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n+"").toCharArray();
        int i = 0;
        for(i = arr.length-1; i > 0; --i) if(arr[i] > arr[i-1]) break;
        if(i == 0) return -1;
        int x = arr[i-1];
        int min = arr[i];
        int j = i;
        for(j = i+1; j < arr.length; ++j) {
            if(arr[j] <= x) break;
        }
        swap(arr, i-1, j-1);
        Arrays.sort(arr, i, arr.length);
        long val = Long.parseLong(String.valueOf(arr));
        return val <= Integer.MAX_VALUE ? (int)val : -1;
    }
    void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return;
    }
}
