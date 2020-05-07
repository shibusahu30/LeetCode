/*
  Cousins in Binary Tree

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:

Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

 

Note:

    The number of nodes in the tree will be between 2 and 100.
    Each node has a unique integer value from 1 to 100.
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
    HashMap<TreeNode, Pair> m;
    Pair lx = new Pair(-1, -1), ly = new Pair(-1, -2);
    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y) return false;
        m = new HashMap<>();
        dfs(root, new Pair(root.val, 0));
        dfs(root, x, y);
        return ((lx.p != ly.p) && (lx.d == ly.d));
    }
    void dfs(TreeNode root, Pair p) {
        if (root == null) return;
        m.put(root, p);
        dfs(root.left, new Pair(root.val, p.d+1));
        dfs(root.right, new Pair(root.val, p.d+1));
    }
    void dfs(TreeNode root, int x, int y) {
        if (root == null) return;
        if (root.val == x) lx = m.get(root);
        else if (root.val == y) ly = m.get(root);
        dfs(root.left, x, y);
        dfs(root.right, x, y);
    }
}
class Pair {
    // To store every nodes corresponding parent p and depth d
    int p, d;
    Pair(int p, int d) {
        this.p = p;
        this.d = d;
    }
}
