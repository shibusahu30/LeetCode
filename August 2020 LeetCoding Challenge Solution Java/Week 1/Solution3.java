/*
Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false

 

Constraints:

    s consists only of printable ASCII characters.
*/
class Solution {
    public boolean isPalindrome(String s) {
        
        String t = "";
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') &&
					!(c >= 'a' && c <= 'z') &&
					!(c >= '0' && c <= '9')) {
				continue;
			}
            t += c+"";
        }
        if(t.length() == 0) return true;
        t = t.toLowerCase();
        // System.out.println(t);
        for(int i = 0; i < t.length()/2; i++) {
            if(t.charAt(i) != t.charAt(t.length()-i-1)) return false;
        }
        return true;
    }
}
