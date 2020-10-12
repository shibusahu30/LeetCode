/*
Remove Duplicate Letters

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 

Example 1:

Input: s = "bcabc"
Output: "abc"

Example 2:

Input: s = "cbacdcbc"
Output: "acdb"

 

Constraints:

    1 <= s.length <= 104
    s consists of lowercase English letters.
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] c = new int[26];
        for(char ch : s.toCharArray()) {
            c[ch-'a']++;
        }
        boolean[] isVis = new boolean[26];
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            int idx = ch-'a';
            c[idx]--;
            if(isVis[idx]) continue;
            while(!st.isEmpty() && ch < st.peek() && c[st.peek()-'a'] != 0) isVis[st.pop()-'a'] = false;
            st.push(ch);
            isVis[ch-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}
