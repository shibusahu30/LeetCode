/*
Single Number III

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor=0;
        for(int n: nums){
            xor ^=n;    
        }
        
        
        int hbit=0;
        for(int i=31;i>=0;i--){
            if((xor>>i&1)==1){
                hbit=i;
                break;
            }
        }
        
        int res[]=new int[2];
        for(int n: nums){
            if((n>>hbit&1)==1){
                res[0] ^=n;
                System.out.println("1");
                
            }
            
        }
        res[1] = xor ^ res[0];
        return res;
    }
}
