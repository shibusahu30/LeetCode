/*
Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // case whene sum is equal to curr val
        map.put(0, 1);
        return dfs(root, sum, 0, map);
    }
    int dfs(TreeNode r, int s, int curr, HashMap<Integer, Integer> map) {
        if(r == null) return 0;
        int c = 0;
        curr += r.val;
        c = map.getOrDefault(curr-s, 0);
        
        map.put(curr, map.getOrDefault(curr, 0)+1);
        c += dfs(r.left, s, curr, map)+dfs(r.right, s, curr, map);
        // remove same curr sum so that it will not affect
        // our calculation in other branch traversal.
        map.put(curr, map.get(curr)-1);
        return c;
    }
}
// gfg explaination to similar type of question: https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
