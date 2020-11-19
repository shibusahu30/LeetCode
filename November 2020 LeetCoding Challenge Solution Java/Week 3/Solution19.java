/*
Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"

 

Constraints:

    1 <= s.length <= 30
    s consists of lowercase English letters, digits, and square brackets '[]'.
    s is guaranteed to be a valid input.
    All the integers in s are in the range [1, 300].
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> intS = new Stack<>();
        Stack<StringBuilder> strS = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int c = 0;
        
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                c = c * 10 + ch-'0';
            } else if(ch == '[') {
                intS.push(c);
                strS.push(ans);
                c = 0;
                ans = new StringBuilder();
            } else if(ch == ']') {
                StringBuilder temp = ans;
                ans = strS.pop();
                for(c = intS.pop(); c > 0; --c) ans.append(temp); 
            } else {
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}
