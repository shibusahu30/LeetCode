/*
Best Time to Buy and Sell Stock with Cooldown

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/
/*

    We already have a stock on day i : stored in dp[i][1] (we will select max of the 2)
    a. We already have it from previous day: dp[i-1][1]
    b. We bought it today: dp[i-2][0]-prices[i]
    We do dp[i-2] because, one day is left for cooldown
    We have no stock on day i : stored in dp[i][0] (we will select max of the 2)
    a. We sell it today : dp[i-1][1] + prices[i]
    b. We did not have a stock earlier too : dp[i-1][0]
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
    	//As you saw in the idea, we need to first compute the values for first 2 days
    	if(prices.length==2)
    		return prices[0]>prices[1] ? 0: prices[1]-prices[0];
    		
    	int[][] dp= new int[prices.length][2];
    	//Evaluating the values for the first 2 days
    	dp[0][0]=0;
    	dp[0][1]=-prices[0];	//If we buy on first day, we need to pay the prices
    	dp[1][0]=Math.max(dp[0][1]+prices[1], dp[0][0]);
    	dp[1][1] = Math.max(dp[0][0]-prices[1], dp[0][1]);
    	
    	
    	for(int i=2; i<prices.length; i++)
    	{
    		dp[i][0]=Math.max(dp[i-1][1]+prices[i], dp[i-1][0]);
        	dp[i][1] = Math.max(dp[i-2][0]-prices[i], dp[i-1][1]);
    	}
    	return dp[prices.length-1][0];
    }
}
