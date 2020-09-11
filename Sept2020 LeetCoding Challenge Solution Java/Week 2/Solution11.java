/*
Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0]; // resultant answer
        int max = ans; // max at a point
        int min = ans; // min at a point
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] < 0) { // if negetaive swap bcoz negative sign do a magic
                int t = max;
                max = min;
                min = t;
            }
            // update all to the requirement
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
