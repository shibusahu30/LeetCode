/*
Buddy Strings

Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.

Example 2:

Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.

Example 3:

Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.

Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
*/
class Solution {
    public boolean buddyStrings(String A, String B) {
        int[] a = new int[26];
        int[] b = new int[26];
        
        for(char ch : A.toCharArray()) ++a[ch-'a'];
        for(char ch : B.toCharArray()) ++b[ch-'a'];
        
        if(A.length() != B.length()) return false;
        
        if(A.equals(B)) {
            for(int i : a) if(i > 1) return true;
            return false;
        } else {
            int c = 0;
            for(int i = 0; i < A.length(); ++i) if(A.charAt(i) != B.charAt(i)) ++c;
            if(c > 2) return false;
            for(int i = 0; i < 26; ++i) if(a[i] != b[i]) return false;
            return true;
        }
    }
}
