/*
 Check If It Is a Straight Line

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

 

Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.

   Hide Hint #1  
      If there're only 2 points, return true.
   Hide Hint #2  
      Check if all other points lie on the line defined by the first 2 points.
   Hide Hint #3  
      Use cross product to check collinearity.
*/
class Solution {
    public boolean checkStraightLine(int[][] co) {
        // Using Hint 1
        if (co.length == 3) return true;
        int x1 = co[0][0];
        int y1 = co[0][1];
        // UsingHint 2
        int m1 = co[1][1] - y1;
        int m2 = co[1][0] - x1;
        // float slope = m1*0.1 / m2;
        for (int i = 2; i < co.length; ++i) {
            int x2 = co[i][0];
            int y2 = co[i][1];
            // Using Hint 3
            if ((y2 - y1) * m2 != (x2 - x1) * m1) return false;
        }
        return true;
    }
}
