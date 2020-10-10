/*
Minimum Number of Arrows to Burst Balloons

There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.

Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to burst all balloons.

 

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4

Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2

Example 4:

Input: points = [[1,2]]
Output: 1

Example 5:

Input: points = [[2,3],[2,3]]
Output: 1

 

Constraints:

    0 <= points.length <= 104
    points.length == 2
    -231 <= xstart < xend <= 231 - 1
*/
class Solution {
    // Sort balloons by its start position in the DECREASING order. 
    // Shoot at current balloon's start position because we want the shoot position to be as left as possible 
    // which will get the best chance to intersect with other balloons. 
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (p1, p2) -> -Integer.compare(p1[0], p2[0]));
        int arrowCount = 1;
        int shootPos = points[0][0];
        for (int i=1; i<points.length; i++) {
            if (points[i][1] >= shootPos) {
                continue;
            } else {
                arrowCount++;
                shootPos = points[i][0];
            }
        }
        return arrowCount;
    }
}
