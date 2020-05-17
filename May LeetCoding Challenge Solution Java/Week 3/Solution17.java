/*
Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        if(n > m) return new ArrayList<>();

        int[] cnt_arr = new int[26];
        for(int i = 0; i < n; i++){
            cnt_arr[s.charAt(i) - 'a']++;
            cnt_arr[p.charAt(i) - 'a']--;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = n; i < m; i++){
            if(areAllZeroes(cnt_arr)){
                list.add(i - n);
            }
            cnt_arr[s.charAt(i) - 'a']++;
            cnt_arr[s.charAt(i - n) - 'a']--;
        }
        if(areAllZeroes(cnt_arr)){
            list.add(m - n);
        }

        return list;
    }
    
    boolean areAllZeroes(int[] cnt_arr){
        for(int i = 0; i < cnt_arr.length; i++){
            if(cnt_arr[i] != 0) return false;
        }
        return true;
    }
}
