/*
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

Input: amount = 10, coins = [10] 
Output: 1

 

Note:

You can assume that

    0 <= amount <= 5000
    1 <= coin <= 5000
    the number of coins is less than 500
    the answer is guaranteed to fit into signed 32-bit integer
*/
//Approach
//A Brute-Force solution is to try all combinations of the given coins to select the ones that give a total sum of amount.

//Base Cases:

//if amount=0 then just return empty set to make the change, so 1 way to make the change.
//if no coins given, 0 ways to change the amount.
//
//Rest of the cases:

//For every coin we have an option to include it in solution or exclude it.
//check if the coin value is less than or equal to the amount needed, if yes then we will find ways by including that coin and excluding that coin.

//Include the coin: reduce the amount by coin value and use the sub problem solution (amount-v[i]).
//Exclude the coin: solution for the same amount without considering that coin.

//Example:
//amount = 5
//coins [] = {1,2,3}

//Using above steps the below is the dp matrix.

//image

//Recursive using include and exclude way

class Solution {
    public int change(int amount, int[] coins) {
        return change(amount, coins, 0);
    }
    
    private static int change(int amount, int[] coins, int i) {
      if (amount < 0) return 0; // if amount is negative by which means not valid - 0
      if (amount == 0) return 1; // we found exact change
      if (i == coins.length && amount > 0) return 0; // means coins over and n>0 so no solution
      return change(amount - coins[i], coins, i) + change(amount, coins, i + 1); // include + exclude
    }
}

//This recursive solution give TLE so for optimizing it we can cache the the solutions of smaller problme either in 2d-DP array or in Map.

//Top Down DP
//I'm not adding code for Top Down DP b/c it is very simple just add the cache in the recursive solution.

//Bottom Up 2D-DP

public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1; 
        for (int j = 1; j <= coins.length; j++) {
            dp[j][0] = 1; // number ways of selecting for amount zero is 1
            for (int i = 1; i <= amount; i++) {
                dp[j][i] = dp[j - 1][i];
                if (i - coins[j - 1] >= 0) { // check if amount  >= to the current i`th coin
                    dp[j][i] += dp[j][i - coins[j - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

//Bottom Up 1-D DP

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1]; // default 0 initialized
        dp[0] = 1; // if nothing to change not select any coin is one way
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) { // iterate j for all coins[i]
                dp[j] += dp[j - coins[i]]; // selecting the coins[i - 1] for amount j
            }
        }

        return dp[amount];
    }
}
/*
TC - O(n * t), where n is the number of coins, and t - the target amount.
SC - O(t).
*/
