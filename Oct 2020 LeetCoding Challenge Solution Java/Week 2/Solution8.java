/*
Binary Search

Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
*/
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int m = l+((r-l)>>1);
            // System.out.println(m);
            if(nums[m] == target) return m;
            else if(target < nums[m]) r = m-1;
            else l = m+1;
        }
        return -1;
    }
}
