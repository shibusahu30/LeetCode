/*
ind Right Interval

Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:

    You may assume the interval's end point is always bigger than its start point.
    You may assume none of these intervals have the same start point.

 

Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
*/
class Solution {
    public int[] findRightInterval(int[][] in) {
        int[] ans = new int[in.length];
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for(int i = 0; i < in.length; ++i) {
            m.put(in[i][0], i);
        }
        for(int i = 0; i < in.length; ++i) {
            Integer ii = m.ceilingKey(new Integer(in[i][1]));
            ans[i] = ii == null ? -1 : m.get(ii);
        }
        return ans;
    }
}
