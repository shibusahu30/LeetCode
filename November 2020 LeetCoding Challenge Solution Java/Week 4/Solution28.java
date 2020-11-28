/*
Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque();
        int[] ans = new int[nums.length-k+1];
        int idx = 0;
        
        for(int i = 0; i < nums.length; ++i) {
            if(q.isEmpty()) q.offer(i);
            else {
                while(!q.isEmpty() && q.peekFirst() < i-k+1) q.pollFirst();
                while(!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
                q.offer(i);
            }
            if(i >= k-1) ans[idx++] = nums[q.peekFirst()];
        }
        
        return ans;
    }
}
