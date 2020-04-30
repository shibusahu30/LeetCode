/*
Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

Note:

    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int c = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            if (map.containsKey(s-k)) {
                c += map.get(s-k);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return c;
    }
}