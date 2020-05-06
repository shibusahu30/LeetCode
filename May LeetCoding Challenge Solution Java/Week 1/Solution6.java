/*
  Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/
class Solution {
    public int majorityElement(int[] nums) {
        // Incase if array is empty.
        // but given array is not empty
        if (nums.length == 0) return 0;
        
        if (nums.length == 1) return nums[0];
        
        // mappinh number to its number of occurence
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0)+1);
        
        // Iterate over hashMap and check the count of the given nmber
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((Integer)pair.getValue() > nums.length/2) return (Integer)pair.getKey();
            it.remove();
        }
        // Incase if we did not find any result then return -1
        return -1;
    }
}
