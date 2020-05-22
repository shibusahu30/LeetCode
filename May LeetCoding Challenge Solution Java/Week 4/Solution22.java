/*
Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
class Solution {
    public String frequencySort(String s) {
        int[] a = new int[256];
        if (s.length() == 0) return "";
        for (char ch : s.toCharArray()) ++a[ch];
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> -Integer.compare(a[x], a[y]));
        for (int i = 0; i < a.length; ++i) q.add(i);
        String ans = "";
        while(!q.isEmpty()) {
            int x = q.poll();
            if (a[x] == 0) break;
            int val = a[x];
            char ch = (char)x;
            while(val-- > 0) ans += ch+"";
        }
        return ans;
    }
}
