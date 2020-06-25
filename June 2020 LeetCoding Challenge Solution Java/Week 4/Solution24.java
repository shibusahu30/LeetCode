/*
 Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
//Solution:
/*    
    n = 0;     null   
    
    count[0] = 1
    
    
	n = 1;      1       
    
    count[1] = 1 
 
    
	n = 2;    1__       			 __2     
    		      \					/                 
    		     count[1]	   	count[1]	
    
    count[2] = 1 + 1 = 2
    
    
    n = 3;    1__				      __2__	                   __3
    		      \		            /       \			      /		
    		  count[2]		  count[1]    count[1]		count[2]
    
    count[3] = 2 + 1 + 2  = 5
    
    
    n = 4;    1__  					__2__					   ___3___                  
    		      \				 /        \					  /		  \			
    		  count[3]		 count[1]    count[2]		  count[2]   count[1]
    
                 __4				
               /
           count[3]   
    
    count[4] = 5 + 2 + 2 + 5 = 14     
*/
class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return foo(n);
    }
    public int foo(int n) {
        if (dp[n] != 0) return dp[n];
        int c = 0;
        for (int i = 1; i <= n; ++i) c += foo(i-1)*foo(n-i);
        dp[n] = c;
        return dp[n];
    }
}
