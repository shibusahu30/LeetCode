/*
Plus One

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/
class Solution {
    public int[] plusOne(int[] d) {
        LinkedList<Integer> ans = new LinkedList<>();
        int x = d[d.length-1]+1;
        int c = x/10;
        ans.addFirst(x%10);
        for (int i = d.length-2; i >= 0; --i) {
            x = d[i]+c;
            ans.addFirst(x%10);
            c = x/10;
        }
        
        
        if (c != 0) ans.addFirst(c);
        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; ++i) a[i] = ans.get(i);
        return a;
    }
}
