/*
Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

 

Constraints:

    1 <= flowerbed.length <= 2 * 104
    flowerbed[i] is 0 or 1.
    There are no two adjacent flowers in flowerbed.
    0 <= n <= flowerbed.length
*/
class Solution {
    public boolean canPlaceFlowers(int[] f, int k) {
        int c = 0;
        int n = f.length;
        if(n == 0) return false;
        if(n == 1) return f[0] == 0 ? k <= 1 : k == 0;
        for(int i = 0; i < n; ++i) {
            if(i == 0 && f[i] == 0 && i+1 < n && f[i+1] == 0) {
                ++c;
                f[i] = 1;
                continue;
            }
            if(i == n-1 && f[i] == 0 && i-1 >= 0 && f[i-1] == 0) {
                ++c; 
                f[i] = 1;
                continue;
            }
            if(i > 0 && i < n-1 && f[i] == 0) {
                System.out.println(i);
                if(f[i-1] == 0 && f[i+1] == 0) {
                    ++c;
                    f[i] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return k <= c;
    }
}
