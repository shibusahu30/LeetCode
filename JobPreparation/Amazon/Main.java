// https://leetcode.com/problems/two-sum/
class Solution {
    public long reducingDishes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0) {
                if (Math.abs(nums[i]) > sum) continue;
                else {
                    sum += nums[i];
                    list.add(nums[i]);
                }
            }else {
                sum += nums[i];
                list.add(nums[i]);
            }
        }
        long answer = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            answer += (i+1) * (list.get(i));
        }
        return answer;
    }
}
