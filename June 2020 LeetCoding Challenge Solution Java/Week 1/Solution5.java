/*
  Random Pick with Weight

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which 
randomly picks an index in proportion to its weight.

Note:

    1 <= w.length <= 10000
    1 <= w[i] <= 10^5
    pickIndex will be called at most 10000 times.

Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. 
pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
*/
class Solution {
    
    private List<Integer> list;
    private Random random;
    private int sum;
    
    public Solution(int[] w) {
      
        list   = new ArrayList<>();
        random = new Random();
        sum    = 0;
        
        list.add(0); 
        
        for(int num : w){
            
            sum += num;
            list.add(sum);
        }
    }
    
    public int pickIndex() {
        
        int index = Collections.binarySearch(list, random.nextInt(sum));
        
        /* 
         * https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#binarySearch
         * "the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1)"
         * if index < 0, return -(index + 1) - 1 => -(index + 2)
         */
        
        return index >= 0? index : -(index + 2);  
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
