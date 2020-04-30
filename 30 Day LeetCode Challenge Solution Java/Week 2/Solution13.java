/*
 Contiguous Array

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000. 
*/
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) if (nums[i] == 0) nums[i] = -1;
        Map<Integer, Integer> map =new HashMap<>();
        int s = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            
            s += nums[i];
            
            if (map.containsKey(s)) {
                int z = i - map.get(s);
                if (z > max) max = z;
            }
            else map.put(s, i);
        }
        
        return max;
    }
}