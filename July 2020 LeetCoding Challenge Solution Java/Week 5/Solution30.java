/*
Word Break II

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }
    List<String> dfs(String s, List<String> w, HashMap<String, List<String>> map) {
        if(map.containsKey(s)) return map.get(s);
        
        
        ArrayList<String> ans = new ArrayList<String>();
        
        if(s.length() == 0) {
            ans.add("");
            return ans;
        }
       
        
        for(String ch: w) {
            if(s.startsWith(ch)) {
                List<String> list = dfs(s.substring(ch.length()), w, map);   
                for(String z : list) ans.add(ch + (z.length() == 0 ? "":" "+z));
            }
            
        }
        map.put(s, ans);
        return ans;
    }
}
