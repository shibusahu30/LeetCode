/*
Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

 

Constraints:

    0 <= s.length <= 105
    s[i] is 'A', 'C', 'G', or 'T'.
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> first = new HashSet<>();
        HashSet<String> second = new HashSet<>();
        for(int i = 0; i < s.length()-9; ++i) {
            String ss = s.substring(i, i+10);
            if(first.contains(ss)) second.add(ss);
            first.add(ss);
        }
        return new ArrayList(second);
    }
}
