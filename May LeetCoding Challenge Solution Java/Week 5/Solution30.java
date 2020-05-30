/*
K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

 

Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000
*/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((A, B) -> Integer.compare(A.dist, B.dist));
        int[][] ans = new int[k][2];
        for (int i = 0; i < points.length; ++i) {
            Pair p = new Pair(points[i][0], points[i][1]);
            pq.offer(p);
        }
        for (int i = 0; i < k; ++i) {
            Pair p = pq.poll();
            ans[i][0] = p.a;
            ans[i][1] = p.b;
        }
        return ans;
    }
    class Pair{
        int a, b, dist;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            dist = a*a + b*b;
        }
    }
}
