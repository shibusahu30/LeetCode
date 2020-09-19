/*
Sequential Digits

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]

Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

 

Constraints:

    10 <= low <= high <= 10^9
*/
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; ++i) {
            int n = i; 
            int ones = n;
            while(n <= high && ones < 10) {
                if(n >= low) ans.add(n);
                int new1 = 10*n + ++ones;
                if(new1 > n) {
                    n = new1;
                } else {
                    break; // Int  overflow
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
