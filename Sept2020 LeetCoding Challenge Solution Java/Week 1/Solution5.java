/*
All Elements in Two Binary Search Trees

Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:

Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]

 

Constraints:

    Each tree has at most 5000 nodes.
    Each node's value is between [-10^5, 10^5].

   Hide Hint #1  
Traverse the first tree in list1 and the second tree in list2.
   Hide Hint #2  
Merge the two trees in one list and sort it.
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        packUp(root1, list1);
        packUp(root2, list2);
        print(list1);
        print(list2);
        List<Integer> list = extraWork(list1, list2);
        return list;
    }
    List<Integer> extraWork(List<Integer> l1, List<Integer> l2) {
        List<Integer> l = new ArrayList<>();
        int i = 0, j = 0;
        int n1 = l1.size();
        int n2 = l2.size();
        while(i < n1 && j < n2) {
            if(l1.get(i) <= l2.get(j)) {
                l.add(l1.get(i++));
            } else {
                l.add(l2.get(j++));
            }
        }
        while(i < n1) {
            l.add(l1.get(i));
            ++i;
        }
        while(j < n2) {
            l.add(l2.get(j));
            ++j;
        }
        return l;
    }
    void packUp(TreeNode r, List<Integer> l) {
        if(r == null) return;
        packUp(r.left, l);
        l.add(r.val);
        packUp(r.right, l);
        return;
    }
    void print(List<Integer> l) {
        for(Integer i : l) System.out.print(i+" ");
        System.out.println();
    }
}
