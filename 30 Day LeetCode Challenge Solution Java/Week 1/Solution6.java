/*
  Group Anagrams

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.


*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        HashMap<String, List> map = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            count = new int[26];
            for (char c: s.toCharArray()) {
                ++count[c - 'a'];
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; ++i) {
                sb.append(count[i]+" ");
            }
            String k = sb.toString();
            if (!map.containsKey(k)) map.put(k, new ArrayList());
            map.get(k).add(s);
        }
        return new ArrayList(map.values());
    }
}