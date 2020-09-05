/*
Partition Labels

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 

Note:

    S will have length in range [1, 500].
    S will consist of lowercase English letters ('a' to 'z') only.

*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int i = 0;
        for(char ch: S.toCharArray()) {
            last[ch-'a'] = i++;
        }
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for(i = 0; i < S.length(); ++i) {
            end = Math.max(end, last[S.charAt(i)-'a']);
            if(i == end) {
                ans.add(i-start+1);
                start = i+1;
            }
        }
        return ans;
    }
}
