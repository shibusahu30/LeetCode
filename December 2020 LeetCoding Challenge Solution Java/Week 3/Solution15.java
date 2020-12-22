/*
Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
*/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length-1;
        int n = nums.length;
        int[] arr = new int[n];
        for(int p = n-1; p >= 0; --p) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                arr[p] = nums[i] * nums[i];
                ++i;
            } else {
                arr[p] = nums[j] * nums[j];
                --j;
            }
        }
        return arr;
    }
}
