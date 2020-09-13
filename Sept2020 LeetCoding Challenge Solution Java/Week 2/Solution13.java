/*
Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        for (int[]interval : intervals) {
            int curStart = interval[0];
            int curEnd = interval[1];
            if (curEnd < start) {
                list.add(new int[]{curStart, curEnd});
            } else if (curStart > end) {
                list.add(new int[]{start, end});
                start = curStart;
                end = curEnd;
            } else {
                start = Math.min(start, curStart);
                end = Math.max(end, curEnd);
            }  
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }      
}
