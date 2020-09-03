/*
Repeated Substring Pattern

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:

Input: "aba"
Output: False

Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = (s+s).substring(1, s.length()*2-1);
        return str.contains(s);
    }
}
/*
I liked this solution and would like to explain this in a simple way.

ss = (s + s)[1:-1]
return ss.find(s) != -1

The maximum length of a "repeated" substring that you could get from a string would be half it's length
For example, s = "abcdabcd", "abcd" of len = 4, is the repeated substring.
You cannot have a substring >(len(s)/2), that can be repeated.

    So, when ss = s + s , we will have atleast 4 parts of "repeated substring" in ss.
    (s+s)[1:-1], With this we are removing 1st char and last char => Out of 4 parts of repeated substring, 2 part will be gone (they will no longer have the same substring).
    ss.find(s) != -1, But still we have 2 parts out of which we can make s. And that's how ss should have s, if s has repeated substring.

*/
