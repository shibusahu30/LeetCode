/*
Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 

Constraints:

    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>> list,ArrayList<Integer> temp,int[] nums,boolean[] stat) {
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length ; i++) {
            if(stat[i] || i > 0 && (nums[i] == nums[i-1] && !stat[i-1])) continue;
            stat[i] = true;
            temp.add(nums[i]);
            backtrack(list,temp,nums,stat);
            stat[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
