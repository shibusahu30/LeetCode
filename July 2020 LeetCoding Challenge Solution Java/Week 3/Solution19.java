/*
Add Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 

Constraints:

    Each string consists only of '0' or '1' characters.
    1 <= a.length, b.length <= 10^4
    Each string is either "0" or doesn't contain any leading zero.
*/
class Solution {
    public String addBinary(String a, String b) {
        int c = 0;
        String ans = "";
        int aL = a.length();
        int bL = b.length();
        int t = aL;
        if(aL < bL) {
            t = bL-aL;
            while(t-- > 0) a = "0"+a;
        } else {
            t = aL-bL;
            while(t-- > 0) b = "0"+b;
        }
        t = a.length();
        System.out.println(a+" "+b+" "+t);
        for(int i = t-1; i >= 0; --i) {
            if(a.charAt(i) == '0' && b.charAt(i) == '0') {
                ans = c+ans;
                c = 0;
            } else if((a.charAt(i) == '0' && b.charAt(i) == '1') || (a.charAt(i) == '1' && b.charAt(i) == '0')){
                if(c == 0) {
                    ans = "1"+ans;
                }
                else {
                    ans = "0"+ans;
                    c = 1;
                }
            } else {
                if(c == 1) {
                    ans = "1"+ans;
                    c = 1;
                } else {
                    ans = "0"+ans;
                    c = 1;
                }
            }
        }
        if(c == 1) ans = "1"+ans;
        return ans;
    }
}
