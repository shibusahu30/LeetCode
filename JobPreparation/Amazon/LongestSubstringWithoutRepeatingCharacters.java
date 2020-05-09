/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        // map every character ti its least recently occured position 
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0,j = 0; j < s.length();j++) {
            if(map.containsKey(s.charAt(j))) {
                // left starting range is the max of last occurence of right range character and the current left range
                // lets say string a b c c f g h d c
                //                 | | | | | | | | |
                //                 0 1 2 3 4 5 6 7 8
                //                         |       |
                //                         i       j
                // map will return map.get('c') i.e 3 but i is at 4, so choose 4 as next i
                i = Math.max(i,map.get(s.charAt(j)));
            }
            max = Math.max(max,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return max;
    }
}
// https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
