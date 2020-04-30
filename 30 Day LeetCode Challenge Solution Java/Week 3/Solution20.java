/*
  Construct Binary Search Tree from Preorder Traversal

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

       8
	  /\
	 5  10
	/\   \
   1 7    12

Note: 

    1 <= preorder.length <= 100
    The values of preorder are distinct.


*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] a) {
        TreeNode root = new TreeNode(a[0]);
        if (a.length == 1) return root;
        if (a.length == 2 && a[1] < a[0]) {
            
            root.left = new TreeNode(a[1]);
            
            return root;
        }
        root = foo(a, a[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    TreeNode foo(int[] a, int k, int min, int max) {
        if (idx >= a.length || k >= max || k <= min) return null;
        TreeNode n = null;
        
        n = new TreeNode(k);
        ++idx;
        if (idx < a.length) {
            n.left = foo(a, a[idx], min, k);
            n.right = foo(a, a[idx], k, max);
        }
        
        return n;
    }
}