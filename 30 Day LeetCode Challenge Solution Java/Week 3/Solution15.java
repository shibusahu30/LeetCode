/*
Product of Array Except Self

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        //if (l == 0) return new int[];
        int[] a = new int[nums.length];
        int sp = 1;
        a[0] = 1;
        for (int i = 1; i < l; ++i) {
            a[i] = nums[i-1] * a[i-1];
        }
        for (int i = l-1; i >= 0; --i) {
            a[i] *= sp;
            sp *= nums[i];
        }
        
        return a;
    }
}