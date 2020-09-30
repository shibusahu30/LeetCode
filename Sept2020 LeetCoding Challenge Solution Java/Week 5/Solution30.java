/*
First Missing Positive

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Follow up:

Your algorithm should run in O(n) time and uses constant extra space.
   Hide Hint #1  
Think about how you would solve the problem in non-constant space. Can you apply that logic to the existing space?
   Hide Hint #2  
We don't care about duplicates or non-positive integers
   Hide Hint #3  
Remember that O(2n) = O(n)
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean one = false;
        for(int i = 0; i < nums.length ; i++) {
            if(nums[i] == 1) {one  = true;break;}
            
        }
        if(!one) return 1;
        if(one && nums.length == 1) return 2;
        
        for( int i = 0; i < nums.length ; i++) {
            if(nums[i] < 1) nums[i] = 1;
        }
        for(int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]);
            if(pos <= nums.length) {
                nums[pos - 1] = -Math.abs(nums[pos - 1]);
            }
        }
        for(int i =0; i < nums.length ; i++) {
            if(nums[i] > 0) return i+1;
        }
        return nums.length+1;
    }
}
