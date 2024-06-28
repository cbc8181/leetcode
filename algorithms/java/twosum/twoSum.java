// source: https://leetcode.com/problems/two-sum/
// difficulty: easy
// Author: Chen
// Date: Jun-27-2024

/****************************************************************************************************************************
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
**************************************************************************************************************************/

// Solution: use HashMap to store the number and its index, 
//           then check if the complement (target - nums[i]) exists in the map
// O(n) time complexity, O(n) space complexity
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }

        return new int[0];
    }
}
