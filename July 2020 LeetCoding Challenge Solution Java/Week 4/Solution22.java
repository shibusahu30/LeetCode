/*
Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        boolean fromLeft = true;
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> mini;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp;
        
        if(root == null) return ans;
        
        q.add(root);
        while(!q.isEmpty()) {
            
            mini = new LinkedList<>();
            int t = q.size();
            
            while(t-- > 0) {
                temp = q.poll();
                
                if(fromLeft) {
                    mini.add(temp.val);
                } else {
                    mini.addFirst(temp.val);
                }
                
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            fromLeft = !fromLeft;
            ans.add(mini);
        }
        return ans;
    }
}
